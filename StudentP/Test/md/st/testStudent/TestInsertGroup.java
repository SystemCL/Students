package md.st.testStudent;

import java.sql.Connection;
import java.sql.SQLException;
import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Address;
import md.st.entity.Group;
import md.st.entity.RetrieveAnnotations;
import md.st.entity.Student;
import md.st.mysqlconn.MySqlAddressDao;
import md.st.mysqlconn.MySqlDaoFactory;
import md.st.mysqlconn.MySqlGroupDao;
import md.st.mysqlconn.MySqlStudentDao;

public class TestInsertGroup extends MySqlGroupDao {

	
	public TestInsertGroup(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws GeneralException, SQLException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Group.class);
	//	System.out.println(RetrieveAnnotations.ColumnAnnotation(Student.class));
		
		
	/*	Group g = new Group();
		g.setNomGroup("FI-111");
		g.setFaculty("FCIM");
		MySqlGroupDao grDAO = new MySqlGroupDao(connection);
		grDAO.insert(g);*/
		
		Group g = new Group();
		g.faculty = "FCIM";
		g.nomGroup = "FAF-151";
		dao.insert(g);
		System.out.println(dao.getAll());
		
		
		
		//g = (Student) factory.getDao(connection, Student.class).insert(g);
		
		
		
		/*Address a = new Address();
		a.setNameAddress("abc");
		a.setNrPhone("21321412");
		
		a = (Address) factory.getDao(connection, Address.class).getByPK(2);*/
		
		
		//System.out.println(a);
		
		//System.out.println(RetrieveAnnotations.ColumnAnnotation(Address.class));
	
		
		
		/*g.nomGroup = "FAF-111";
		g.faculty = "FCIM";
		MySqlGroupDao grDAO1 = new MySqlGroupDao(connection);
		grDAO1.insert(g);
	    
		System.out.print(grDAO.getByPK(2)+" ");*/
	    //System.out.print(stDAO1.getByPK(2).getLastName());
	   
		connection.close();
	}
	
	
	
	

}
