package md.st.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.dao.PersistException;
import md.st.entity.Address;



public class MySqlAddressDao extends AbstractJDBCDao<Address, Integer> {
	private class PersistAddress extends Address {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	 @Override
	    public String getSelectQuery() { 
	        return "SELECT id, nameAddress, nrPhone  FROM studentsdb.Address";
	    }

	 @Override
	    public String getCreateQuery() {
	        return "INSERT INTO studentsdb.Address (nameAddress, nrPhone) \n" +
	                "VALUES (?, ?);";
	    }
	 
	 @Override
	    public String getUpdateQuery() {
	        return "UPDATE studentsdb.Address SET nameAddress= ? nrPhone = ? WHERE id= ?;";
	    }
	 
	 @Override
	    public String getDeleteQuery() {
	        return "DELETE FROM studentsdb.Address WHERE id= ?;";
	    }
	 
	 @Override
	    public Address create() throws PersistException {
	        Address g = new Address();
	        return persist(g);
	    }
	 
	 public MySqlAddressDao(Connection connection) {
	        super(connection);
	    }
	 
	 @Override
	    protected List<Address> parseResultSet(ResultSet rs) throws PersistException{
	    	LinkedList<Address> result = new LinkedList<Address>();
	    	try {
	            while (rs.next()) {
	                PersistAddress address = new PersistAddress();
	                address.setId(rs.getInt("id"));
	                address.setNameAddress(rs.getString("nameAddress"));
	                address.setNrPhone(rs.getString("nrPhone"));
	                
	                result.add(address);
	            }
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
			return result;
	    	
	    }
	 
	 @Override
	    protected void prepareStatementForInsert(PreparedStatement statement, Address object) throws PersistException {
	        try {
	        	statement.setString(1, object.getNameAddress());
	            statement.setString(2, object.getNrPhone());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }
	 
	 @Override
	    protected void prepareStatementForUpdate(PreparedStatement statement, Address object) throws PersistException {
	        try {
	            statement.setString(1, object.getNameAddress());
	            statement.setString(2, object.getNrPhone());
	            statement.setInt(3, object.getId());
	        } catch (Exception e) {
	            throw new PersistException(e);
	        }
	    }
	 
	 
}
