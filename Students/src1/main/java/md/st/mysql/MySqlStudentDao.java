package md.st.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import md.st.dao.AbstractJDBCDao;
import md.st.entity.Student;
import md.st.dao.PersistException;


public class MySqlStudentDao extends AbstractJDBCDao<Student, Integer> {
	private class PersistStudent extends Student {
        public void setId(int id) {
            super.setId(id);
        }
    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, firstName, lastName, age, enrolment_date FROM studentsdb.Student ";
    }
    
    @Override
    public String getCreateQuery() {
        return "INSERT INTO studentsdb.Student (firstName, lastName, age, enrolment_date ) \n" +
                "VALUES (?, ?, ?, ?);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE studentsdb.Student \n" +
                "SET firstName = ?, lastName  = ?, age = ?, enrolment_date = ? \n" +
                "WHERE id = ?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM studentsdb.Student WHERE id = ?;";
    }

    @Override
    public Student create() throws PersistException {
        Student s = new Student();
        return persist(s);
    }

    public MySqlStudentDao(Connection connection) {
        super(connection);
    }

    @Override
    protected List<Student> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Student> result = new LinkedList<Student>();
        try {
            while (rs.next()) {
                PersistStudent student = new PersistStudent();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAge(rs.getInt("age"));
                student.setEnrolment_date(rs.getDate("enrolment_date"));
         
                // student.setGroup_id(rs.getInt("group_id"));
                result.add(student);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Student object) throws PersistException {
        try {
            Date sqlDate = convert(object.getEnrolment_date());
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setInt(3, object.getAge());
            statement.setDate(4, sqlDate);
           
          //  statement.setInt(5, object.getGroup_id());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Student object) throws PersistException {
        try {
            Date sqlDate = convert(object.getEnrolment_date());
          //  int studentId = (object.getGroup_id() == null) ? 0 : object.getGroup_id();
            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setInt(3, object.getAge());
            statement.setDate(4, sqlDate);
      
           // statement.setInt(5, studentId);
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
