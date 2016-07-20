package md.st.testStudent;

import java.sql.Connection;
import java.util.Date;

import md.st.dao.DaoFactory;
import md.st.dao.GeneralException;
import md.st.dao.GenericDao;
import md.st.entity.Group;
import md.st.entity.Student;
import md.st.mysqlconn.MySqlDaoFactory;
import md.st.mysqlconn.MySqlGroupDao;

public class TestGroupBuilder{

	
@SuppressWarnings("unchecked")
public static <T> void main(String[] args) throws GeneralException {
	DaoFactory<Connection> factory = new MySqlDaoFactory();
	Connection connection = (Connection) factory.getContext(); 
	GenericDao dao = factory.getDao(connection, Group.class);
	
	Group gr = new Group();
     gr = new Group().nomGroup("AI-131").faculty("FRT");
     dao.insert(gr);
     
     Group gr1 = new Group();
     gr1.setFaculty("YYY");
     gr1.setNomGroup("IIII");
     
    Group c =  (Group) dao.getByPK(1);
    dao.delete(c);
     
     //gr1 = factory.getDao(connection, Group.class).update(gr);
   //  dao.update(gr1);
}
	

}
