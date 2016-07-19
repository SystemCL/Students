package md.st.mysqlconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.dao.GeneralException;
import md.st.entity.Address;
import md.st.entity.RetrieveAnnotations;
import md.st.entity.annotations.Column;



public class MySqlAddressDao extends AbstractJDBCDao<Address, Integer> {
	private class PersistAddress extends Address {
        public void setId(int id) {
            super.setId(id);
        }
    }
	
	 @Override
	    public String getSelectQuery() { 
	        return "SELECT * FROM "+ RetrieveAnnotations.EntityAnnotation(Address.class); //id, nameAddress, nrPhone
	    }

	 @Override
	    public String getCreateQuery() {
	        return "INSERT INTO "+RetrieveAnnotations.EntityAnnotation(Address.class)+" (`nameAddress` , `nrPhone`) \n" +
	                "VALUES (?, ?);";
	    }
	 
	 @Override
	    public String getUpdateQuery() {
	        return "UPDATE " +RetrieveAnnotations.EntityAnnotation(Address.class)+ " SET " +RetrieveAnnotations.ColumnAnnotationUpdate(Address.class)+ " WHERE id= ?;"; //nameAddress= ? nrPhone = ?
	    }
	 
	 @Override
	    public String getDeleteQuery() {
	        return "DELETE FROM "+RetrieveAnnotations.EntityAnnotation(Address.class)+" WHERE id= ?;";
	    }
	 
	 @Override
	    public Address create() throws GeneralException {
	        Address g = new Address();
	        return insert(g);
	    }
	 
	 public MySqlAddressDao(Connection connection) {
	        super(connection);
	    }
	 
	 @Override
	    protected List<Address> parseResultSet(ResultSet rs) throws GeneralException{
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
	            throw new GeneralException(e);
	        }
			return result;
	    	
	    }
	 
	 @Override
	    protected void prepareStatementForInsert(PreparedStatement statement, Address object) throws GeneralException {
	        try {
	        	statement.setString(1, object.getNameAddress());
	            statement.setString(2, object.getNrPhone());
	        } catch (Exception e) {
	            throw new GeneralException(e);
	        }
	    }
	 
	 @Override
	    protected void prepareStatementForUpdate(PreparedStatement statement, Address object) throws GeneralException {
	        try {
	            statement.setString(1, object.getNameAddress());
	            statement.setString(2, object.getNrPhone());
	            statement.setInt(3, object.getId());
	        } catch (Exception e) {
	            throw new GeneralException(e);
	        }
	    }

	@Override
	public String getAllSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	 
	 
}
