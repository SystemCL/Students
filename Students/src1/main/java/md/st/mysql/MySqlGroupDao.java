package md.st.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.dao.PersistException;
import md.st.entity.Group;

public class MySqlGroupDao extends AbstractJDBCDao<Group, Integer> {

	 private class PersistGroup extends Group {
	        public void setId(int id) {
	            super.setId(id);
	        }
	    }

	    @Override
	    public String getSelectQuery() { 
	        return "SELECT id, nameGroup, faculty FROM studentsdb.Group";
	    }

	    @Override
	    public String getCreateQuery() {
	        return "INSERT INTO studentsdb.Group (nameGroup, faculty) \n" +
	                "VALUES (?, ?);";
	    }

	    @Override
	    public String getUpdateQuery() {
	        return "UPDATE studentsdb.Group SET nameGroup = ? faculty = ? WHERE id = ?;";
	    }

	    @Override
	    public String getDeleteQuery() {
	        return "DELETE FROM studentsdb.Group WHERE id = ?;";
	    }

	    @Override
	    public Group create() throws PersistException {
	        Group g = new Group();
	        return persist(g);
	    }

	    public MySqlGroupDao(Connection connection) {
	        super(connection);
	    }

	    @Override
	    protected List<Group> parseResultSet(ResultSet rs) throws PersistException {
	        LinkedList<Group> result = new LinkedList<Group>();
	        try {
	            while (rs.next()) {
	                PersistGroup group = new PersistGroup();
	                group.setId(rs.getInt("id"));
	                group.setNomGroup(rs.getString("nameGroup"));
	                group.setFaculty(rs.getString("faculty"));
	                result.add(group);
	            }
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	        return result;
	    }

	    @Override
	    protected void prepareStatementForInsert(PreparedStatement statement, Group object) throws PersistException {
	        try {
	            statement.setString(1, object.getNomGroup());
	            statement.setString(2, object.getFaculty());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }

	    @Override
	    protected void prepareStatementForUpdate(PreparedStatement statement, Group object) throws PersistException {
	        try {
	            statement.setString(1, object.getNomGroup());
	            statement.setString(2, object.getFaculty());
	            statement.setInt(3, object.getId());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }

}
