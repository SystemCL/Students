package md.st.testStudent;

import java.sql.Connection;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Address;
import md.st.mysqlconn.MySqlAddressDao;
import md.st.mysqlconn.MySqlDaoFactory;

public class TestInsertAddress extends MySqlAddressDao {

	public TestInsertAddress(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws GeneralException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Address.class);
	
	
		Address a = new Address();
		a.setNameAddress("str. Burebista 23/3");
		a.setNrPhone("079367891");
		dao.insert(a);
		
		System.out.println(dao.getAll());
		
		
	}
	

}
