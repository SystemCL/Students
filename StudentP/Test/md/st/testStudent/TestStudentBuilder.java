package md.st.testStudent;
import java.sql.Connection;

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
	     st = new StudentBuilder().firstName("Haralambie").lastName("Petru").build();
		
		dao.insert(st);
	}
}
