package md.st.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.dao.PersistException;
import md.st.entity.Course;


public class MySqlCourseDao extends AbstractJDBCDao<Course, Integer> {
	private class PersistCourse extends Course {
        public void setId(int id) {
            super.setId(id);
        }
    }


    @Override
    public String getSelectQuery() { 
        return "SELECT id, nameCourse, nameProf, startDate, endDate FROM studentsdb.Course";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO studentsdb.Course (nameCourse, nameProf, startDate, endDate) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE studentsdb.Course SET nameCourse= ? nameProf = ? startDate = ? endDate = ? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM studentsdb.Course WHERE id= ?;";
    }

    @Override
    public Course create() throws PersistException {
        Course g = new Course();
        return persist(g);
    }

    public MySqlCourseDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Course> parseResultSet(ResultSet rs) throws PersistException{
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
            throw new PersistException(e);
        }
		return result;
    	
    }
    
    /*protected List<Course> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Course> result = new LinkedList<Course>();
        try {
            while (rs.next()) {
                PersistGroup group = new PersistGroup();
                group.setId(rs.getInt("idCourse"));
                group.set
                group.setFaculty(rs.getString("faculty"));
                result.add(group);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }
*/
    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Course object) throws PersistException {
        try {
        	Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
        	statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Course object) throws PersistException {
        try {
        	Date sqlDateS = convert(object.getStartDate());
        	Date sqlDateE = convert(object.getEndDate());
            statement.setString(1, object.getNameCourse());
            statement.setString(2, object.getNameProf());
            statement.setDate(3, sqlDateS);
            statement.setDate(4, sqlDateE);
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }
    protected java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

}
