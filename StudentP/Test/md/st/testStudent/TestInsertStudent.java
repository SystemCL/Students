package md.st.testStudent;

import java.sql.Connection;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Group;
import md.st.entity.RetrieveAnnotations;
import md.st.entity.Student;
import md.st.entity.Student1;
import md.st.mysqlconn.MySqlDaoFactory;
import md.st.mysqlconn.MySqlStudentDao;

public class TestInsertStudent extends MySqlStudentDao {

	public TestInsertStudent(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws GeneralException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext();
		GenericDao dao = factory.getDao(connection, Student.class);
		
		//System.out.println(RetrieveAnnotations.ColumnAnnotation(Student.class));
		//System.out.println(dao.getAll());
		
		Student s = new Student();
		s.setFirstName("abcde");
		s.setLastName("cdefg");
		s.setAge(21);
		s.setEnrolment_date(null);
		
		//s = (Student) factory.getDao(connection, Student.class).insert(s);
		dao.insert(s);
		System.out.println(dao.getByPK(1));
		System.out.println(dao.getAll());
		
		
		
		//Student1 student1 = new Student1.Builder().firstName("abc").lastName("def").age(21).build();
		
		//student1 = (Student1) factory.getDao(connection, Student1.class).insert(student1);
		
	}

}
