package md.st.testStudent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import md.st.entity.AllAnnotations;
import md.st.entity.Student;
import md.st.mysqlconn.MySqlConnection;

public class TestStudent extends AllAnnotations {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		System.out.print("Enter student ID: ");
		
		int studentId;
		
		try {
			studentId = Integer.parseInt(br.readLine());
			TestStudent demo = new TestStudent();
			Student student = demo.getStudent(studentId);
			System.out.println(student);
			
			String a = "ABCDE,";
			System.out.println(a.substring(5).replace(a.substring(5, 6), ""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//EntAnt(Student.class);
	//	ColAnt(Student.class);
		AllAnnotations.ColAnt(Student.class);

		
	}
	

	public Student getStudent(int studentId) {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		Student student = null;
		//String query = "SELECT * FROM "+ AllAnnotations.EntAnt(Student.class) + " WHERE id=" + studentId; //studentId
		String query = "SELECT * FROM "+ AllAnnotations.EntAnt(Student.class) + " WHERE id=" + studentId; //studentId
		
		try {
			connection = MySqlConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if(rs == null){
				System.out.print("Cannot access the object with id=" +studentId);
			}

			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setAge(rs.getInt("age"));
				student.setEnrolment_date(rs.getDate("enrolment_date"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}
		return student;

	}

}
