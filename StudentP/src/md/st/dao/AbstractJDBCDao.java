package md.st.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import md.st.dao.GenericDao;
import md.st.dao.Identification;
//import md.student.dao.PersistException;

public abstract class AbstractJDBCDao<T extends Identification<PK>, PK extends Integer> implements GenericDao<T, PK> {
	private Connection connection;
/*Intoarce cererea de sql pentru toate inregistrarile
 * SELECT * FROM [Table]*/
    
    public abstract String getSelectQuery();
    
    public abstract String getAllSelectQuery();
    
    public abstract String getCreateQuery();
 
    public abstract String getUpdateQuery();
   
    public abstract String getDeleteQuery();
    
    public abstract String resertAutoIncrement();

/* Se intoarce lista de obiecte care corespund cu contentul lui ResultSet*/ 
    protected abstract List<T> parseResultSet(ResultSet rs) throws GeneralException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws GeneralException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws GeneralException;

    @Override
    public T insert(T object) throws GeneralException {
        T persistInstance = null;
        
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new GeneralException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new GeneralException(e);
        }
        
        sql = getSelectQuery() + " WHERE id = last_insert_id();";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            List<T> list = parseResultSet(rs);
            if ((list == null) || (list.size() != 1)) {
                throw new GeneralException("Exception on findByPK new persist data.");
            }
            persistInstance = list.iterator().next();
        } catch (Exception e) {
            throw new GeneralException(e);
        }
        return persistInstance;
    }

    @Override
    public T getByPK(Integer key) throws GeneralException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new GeneralException(e);
        }
        if (list == null || list.size() == 0) {
            throw new GeneralException("Record with PK = " + key + " not found.");
        }
        if (list.size() > 1) {
            throw new GeneralException("Received more than one record.");
        }
        return list.iterator().next();
    }

    @Override
    public void update(T object) throws GeneralException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object); 
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new GeneralException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    public void delete(T object) throws GeneralException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setObject(1, object.getId());
            } catch (Exception e) {
                throw new GeneralException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new GeneralException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    public List<T> getAll() throws GeneralException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new GeneralException(e);
        }
        return list;
    }

    public AbstractJDBCDao(Connection connection) {
        this.connection = connection;
    }

}
