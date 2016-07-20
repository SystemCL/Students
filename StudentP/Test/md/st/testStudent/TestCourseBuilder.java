package md.st.testStudent;

import java.sql.Connection;
import java.util.Date;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Course;
import md.st.entity.Group;
import md.st.mysqlconn.MySqlCourseDao;
import md.st.mysqlconn.MySqlDaoFactory;

public class TestCourseBuilder extends MySqlCourseDao {
	
public TestCourseBuilder(Connection connection) {
		super(connection);
	}

public static void main(String[] args) throws GeneralException {
	DaoFactory<Connection> factory = new MySqlDaoFactory();
	Connection connection = (Connection) factory.getContext(); 
	GenericDao dao = factory.getDao(connection, Course.class);
	
	Course crs = new Course();
	Date start_date = convert(new Date("2016/09/03"));
	Date end_date = convert(new Date("2017/02/03"));
     crs = new Course().nameCourse("PAIPP").nameProf("Moglan Viorica").startDate(start_date).endDate(end_date).build();
     dao.insert(crs);
     crs = new Course().nameCourse("BDC").nameProf("Mironov Bettin").startDate(start_date).endDate(end_date).build();
     dao.insert(crs);
     
    //System.out.println(dao.getAll());
}

}
