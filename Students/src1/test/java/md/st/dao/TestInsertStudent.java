package md.st.dao;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import md.st.entity.Student;
import md.st.mysql.MySqlDaoFactory;
import md.st.mysql.MySqlStudentDao;


public class TestInsertStudent extends MySqlStudentDao {

	
	public TestInsertStudent(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws PersistException, SQLException {
		// TODO Auto-generated method stub
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Student.class);
	
		/*Student c = new Student();
		c.firstName = "Corneliu";
		c.lastName = "Vadim";
		c.age = 23;
        String a = "2016/02/14";
		c.enrolment_date = new Date(a);
		c = (Student) factory.getDao(connection, Student.class).persist(c);*/
		
		/*Statement st = connection.createStatement();
		st.executeUpdate("INSERT INTO Student (firstName, lastName, age, enrolment_Date) " + " VALUES ('Ciorba','Victor',25, '2016-02-11')");
		st.execute("INSERT INTO Student (firstName, lastName, age, enrolment_Date) " + " VALUES ('Ciorba11','Victor11',22, '2016-02-11')");*/
		
		Student c = new Student();
		c.setFirstName("WWWW");
		c.setLastName("QQQQQ");
		c.setAge(23);
		String a = "2016/02/03";
		c.setEnrolment_date(new Date(a));
		MySqlStudentDao stDAO = new MySqlStudentDao(connection);
		stDAO.persist(c);
		
		
		c.firstName = "Corneliu";
		c.lastName = "Vadim";
		c.age = 23;
        String b = "2016/02/14";
		c.enrolment_date = new Date(b);
		MySqlStudentDao stDAO1 = new MySqlStudentDao(connection);
		stDAO.persist(c);
        
		System.out.print(stDAO1.getByPK(2).getFirstName()+" ");
        System.out.print(stDAO1.getByPK(2).getLastName());
        
		connection.close();
		
		
		
		/*
		String query = "INSERT INTO Student VALUES (firstName, lastName, age, enrolment_Date) values (?,?,?,?)";
		pstmt = connection.prepareStatement(query);*/
		//String
		//getCreateQuery
		
		/*List<Student> abc = factory.getDao(connection, Student.class).getAll();
		for (Student s: abc) 
			System.out.println(s.age);
		     System.out.println();*/
			
		
		//abc.forEach(System.out::println);
		
		
		
		
	
		

		
	}

}
