package md.st.testStudent;

import java.sql.Connection;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Address;
import md.st.entity.Course;
import md.st.entity.Group;
import md.st.mysqlconn.MySqlDaoFactory;

public class TestAddressBuilder {
	
	public static void main(String[] args) throws GeneralException {
		DaoFactory<Connection> factory = new MySqlDaoFactory();
		Connection connection = (Connection) factory.getContext(); 
		GenericDao dao = factory.getDao(connection, Address.class);
		
		Address adr = new Address();
	     adr = new Address().nameAddress("str. Ginta Latina 20/2").nrPhone("+373068485697").build();
	     dao.insert(adr);
	     
	     Address adr1 =  (Address) dao.getByPK(8);
	     dao.delete(adr1);
	}

}
