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
import md.st.entity.Course;


public class MySqlCourseDao extends AbstractJDBCDao<Course, Integer> {
	private class PersistCourse extends Course {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() { 
        return "SELECT " + RetrieveAnnotations.ColumnAnnotation(Course.class) + " FROM "+ RetrieveAnnotations.EntityAnnotation(Course.class)+";";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO "+RetrieveAnnotations.EntityAnnotation(Course.class)+" ("+RetrieveAnnotations.ColumnAnnotation(Course.class) + ") \n" +
        "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE " +RetrieveAnnotations.EntityAnnotation(Course.class)+ " SET " +RetrieveAnnotations.ColumnAnnotationUpdate(Course.class)+ " WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM "+RetrieveAnnotations.EntityAnnotation(Course.class)+" WHERE id= ?;";
    }

    @Override
    public Course create() throws GeneralException {
        Course g = new Course();
        return insert(g);
    }

    public MySqlCourseDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Course> parseResultSet(ResultSet rs) throws GeneralException{
    	LinkedList<Course> result = new LinkedList<Course>();
    	try {
            while (rs.next()) {
                PersistCourse course = new PersistCourse();
                course.setId(rs.getInt("id"));
                course.setNameCourse(rs.getString("nameCourse"));
                course.setNameProf(rs.getString("nameProf"));
                course.setStartDate(rs.getDate("startDate"));
                course.setEndDate(rs.getDate("endDate"));
                result.add(course);
            }
        } catch (Exception e) {
            throw new GeneralException(e);
        }
		return result;
    	
    }
    
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Course object) throws GeneralException {
        try {
        	Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
        	statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Course object) throws GeneralException {
        try {
        	Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
            statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }
    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

	@Override
	public String getAllSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
