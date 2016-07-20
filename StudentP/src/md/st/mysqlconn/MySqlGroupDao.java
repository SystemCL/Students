package md.st.mysqlconn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.dao.GeneralException;
import md.st.entity.RetrieveAnnotations;
import md.st.entity.Student;
import md.st.entity.Course;
import md.st.entity.Group;

public class MySqlGroupDao extends AbstractJDBCDao<Group, Integer> {

	 private class PersistGroup extends Group {
	        public void setId(int id) {
	            super.setId(id);
	        }
	    }

	    @Override
	    public String getSelectQuery() { 
	        return "SELECT " + RetrieveAnnotations.ColumnAnnotation(Group.class) + " FROM "+ RetrieveAnnotations.EntityAnnotation(Group.class);
	    }

	    @Override
	    public String getCreateQuery() {
	        return "INSERT INTO "+RetrieveAnnotations.EntityAnnotation(Group.class)+" (`nameGroup`, `faculty`) \n" +
	                "VALUES (?, ?);";
	    }

	    @Override
	    public String getUpdateQuery() {
	        return "UPDATE " +RetrieveAnnotations.EntityAnnotation(Group.class)+ " SET " +RetrieveAnnotations.ColumnAnnotationUpdate(Group.class)+ " WHERE id= ?;";
	    }

	    @Override
	    public String getDeleteQuery() {
	    	return "DELETE FROM "+RetrieveAnnotations.EntityAnnotation(Group.class)+" WHERE id= ?;";
	    }

	    @Override
	    public Group create() throws GeneralException {
	        Group g = new Group();
	        return insert(g);
	    }

	    public MySqlGroupDao(Connection connection) {
	        super(connection);
	    }

	    @Override
	    protected List<Group> parseResultSet(ResultSet rs) throws GeneralException {
	        LinkedList<Group> result = new LinkedList<Group>();
	        try {
	            while (rs.next()) {
	                PersistGroup group = new PersistGroup();
					group.setId((int)rs.getObject(1));
					group.setNomGroup((String)rs.getObject(2));
					group.setFaculty((String)rs.getObject(3));
	               /*group.setId(rs.getInt("id"));
	                group.setNomGroup(rs.getString("nameGroup")); 
	                group.setFaculty(rs.getString("faculty"));*/
	                result.add(group);
	            }
	        } catch (Exception e) {
	            throw new GeneralException(e);
	        }
	        return result;
	    }

	    @Override
	    protected void prepareStatementForInsert(PreparedStatement statement, Group object) throws GeneralException {
	        try {
	        	statement.setObject(1, object.getNomGroup());
				statement.setObject(2, object.getFaculty());        	
	          /*statement.setString(1, object.getNomGroup());
	            statement.setString(2, object.getFaculty());*/
	        } catch (Exception e) {
	            throw new GeneralException(e);
	        }
	    }

	    @Override
	    protected void prepareStatementForUpdate(PreparedStatement statement, Group object) throws GeneralException {
	        try {
	        	statement.setObject(1, object.getNomGroup());
				statement.setObject(2, object.getFaculty());
				statement.setObject(3, object.getId());
	          /*statement.setString(1, object.getNomGroup());
	            statement.setString(2, object.getFaculty());
	            statement.setInt(3, object.getId());*/
	        } catch (Exception e) {
	            throw new GeneralException(e);
	        }
	    }

		@Override
		public String getAllSelectQuery() {
			// TODO Auto-generated method stub
			return "SELECT * FROM "+ RetrieveAnnotations.EntityAnnotation(Group.class);
		}

		@Override
		public String resertAutoIncrement() {
			// TODO Auto-generated method stub
			return null;
		}

}
