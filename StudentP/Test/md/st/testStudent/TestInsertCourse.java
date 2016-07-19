package md.st.testStudent;

import java.sql.Connection;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Course;
import md.st.entity.Group;
import md.st.mysqlconn.MySqlCourseDao;
import md.st.mysqlconn.MySqlDaoFactory;

public class TestInsertCourse extends MySqlCourseDao {

	public TestInsertCourse(Connection connection) {
		super(connection);
	}
	

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws GeneralException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Course.class);
		
		Course c = new Course();
		c.setNameCourse("DPA");
		c.setNameProf("Hrusca Valeriu");
		c.setStartDate(null);
		c.setEndDate(null);
		dao.insert(c);
		
		System.out.println(dao.getAll());
	}
}
