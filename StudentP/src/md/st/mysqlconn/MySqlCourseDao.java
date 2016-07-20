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


public class MySqlCourseDao extends AbstractJDBCDao<Course, Integer> {
	private class PersistCourse extends Course {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() { 
        return "SELECT * FROM "+ RetrieveAnnotations.EntityAnnotation(Course.class);
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO "+RetrieveAnnotations.EntityAnnotation(Course.class)+" (`nameCourse`,`nameProf`,`startDate`,`endDate`) \n" +
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
				course.setId((int)rs.getObject(1));
				course.setNameCourse((String)rs.getObject(2));
				course.setNameProf((String)rs.getObject(3));
				course.setStartDate((Date)rs.getObject(4));
				course.setEndDate((Date)rs.getObject(5));
              /*course.setId(rs.getInt("id"));
                course.setNameCourse(rs.getString("nameCourse"));
                course.setNameProf(rs.getString("nameProf"));
                course.setStartDate(rs.getDate("startDate"));
                course.setEndDate(rs.getDate("endDate"));*/
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
        	statement.setObject(1, object.getNameCourse());
			statement.setObject(2, object.getNameProf());
			statement.setObject(3, object.getStartDate());
			statement.setObject(4, object.getEndDate());
          /*Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
        	statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);*/
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Course object) throws GeneralException {
        try {
        	statement.setObject(1, object.getNameCourse());
			statement.setObject(2, object.getNameProf());
			statement.setObject(3, object.getStartDate());
			statement.setObject(4, object.getEndDate());
			statement.setObject(5, object.getId());
          /*Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
            statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);
            statement.setInt(5, object.getId());*/
        } catch (Exception e) {
            throw new GeneralException(e);
        }
    }
    protected static java.sql.Date convert(java.util.Date date) {
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

	@Override
	public String resertAutoIncrement() {
		// TODO Auto-generated method stub
		return null;
	}

}
