package md.st.testStudent;
import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.spi.DateFormatProvider;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.*;
import md.st.mysqlconn.MySqlDaoFactory;
import md.st.mysqlconn.MySqlStudentDao;


public class TestStudentBuilder extends MySqlStudentDao {

	public TestStudentBuilder(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws GeneralException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Student.class);
		
		Student st = new Student();
		@SuppressWarnings("deprecation")
		Date enrolment_student = convert(new Date());
	     st = new Student().firstName("Ciorescu").lastName("Petru").age(21).enrolment_date(enrolment_student).build();
	    // dao.insert(st);

	     Student student =  (Student) dao.getByPK(170);
	     dao.delete(student);
	     
		
	    
	
	
	}
}
