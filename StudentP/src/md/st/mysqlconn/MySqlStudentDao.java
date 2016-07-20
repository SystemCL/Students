package md.st.mysqlconn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.entity.RetrieveAnnotations;
import md.st.entity.Course;
import md.st.entity.Student;
import md.st.dao.GeneralException;

public class MySqlStudentDao extends AbstractJDBCDao<Student, Integer> {
	private class PersistStudent extends Student {
		public void setId(int id) {
			super.setId(id);
		}
	}

	@Override
	public String getSelectQuery() {
		return "SELECT " + RetrieveAnnotations.ColumnAnnotation(Student.class) + " FROM " + RetrieveAnnotations.EntityAnnotation(Student.class);
	}
	
	@Override
	public String getAllSelectQuery() {
		return "SELECT * FROM " + RetrieveAnnotations.EntityAnnotation(Student.class);
	}

	@Override
	public String getCreateQuery() {
		return "INSERT INTO " + RetrieveAnnotations.EntityAnnotation(Student.class) + "(`firstName`, `lastName`, `age`, `enrolment_date`) \n" + "VALUES (?, ?, ?, ?);";
	}

	@Override
	public String getUpdateQuery() {

		return "UPDATE " + RetrieveAnnotations.EntityAnnotation(Student.class) + " SET " + RetrieveAnnotations.ColumnAnnotationUpdate(Student.class)
				+ " WHERE id= ?;";

	}

	@Override
	public String getDeleteQuery() {
		return "DELETE FROM "+RetrieveAnnotations.EntityAnnotation(Student.class)+" WHERE id= ?;";
	}

	@Override
	public Student create() throws GeneralException {
		Student s = new Student();
		return insert(s);
	}

	public MySqlStudentDao(Connection connection) {
		super(connection);
	}

	@Override
	protected List<Student> parseResultSet(ResultSet rs) throws GeneralException {
		LinkedList<Student> result = new LinkedList<Student>();
		try {
			while (rs.next()) {
        		PersistStudent student = new PersistStudent();
				student.setId((int)rs.getObject(1));
				student.setFirstName((String) rs.getObject(2));
                student.setLastName((String)rs.getObject(3));
                student.setAge((int)rs.getObject(4));
                student.setEnrolment_date((Date)rs.getObject(5));
			  /*student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAge(rs.getInt("age"));
                student.setEnrolment_date(rs.getDate("enrolment_date"));*/
				result.add(student);
			}
		} catch (Exception e) {
			throw new GeneralException(e);
		}
		return result;
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement, Student object) throws GeneralException {
		try {
			//Date sqlDate = convert(object.getEnrolment_date());
		    
			statement.setObject(1, object.getFirstName());
			statement.setObject(2, object.getLastName());
			statement.setObject(3, object.getAge());
			statement.setObject(4, object.getEnrolment_date());	
		  /*statement.setString(1, object.getFirstName());
			statement.setString(2, object.getLastName());
			statement.setInt(3, object.getAge());
			statement.setDate(4, sqlDate);*/

			// statement.setInt(5, object.getGroup_id());
		} catch (Exception e) {
			throw new GeneralException(e);
		}
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement, Student object) throws GeneralException {
		try {
				
			//Date sqlDate = convert(object.getEnrolment_date());
		    //	 int studentId = (object.getGroup_id() == null) ? 0 : object.getGroup_id();
			
			statement.setObject(1, object.getFirstName());
			statement.setObject(2, object.getLastName());
			statement.setObject(3, object.getAge());
			statement.setObject(4, object.getEnrolment_date());	
		  /*statement.setString(1, object.getFirstName());	
			statement.setString(2, object.getLastName());
			statement.setInt(3, object.getAge());
			statement.setDate(4, sqlDate);
*/
			// statement.setInt(5, studentId);
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
	public String resertAutoIncrement() {
		// TODO Auto-generated method stub
		return "ALTER TABLE " + RetrieveAnnotations.EntityAnnotation(Student.class) + " AUTO_INCREMENT = ";
	}



}
