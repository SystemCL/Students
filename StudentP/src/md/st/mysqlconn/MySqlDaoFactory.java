package md.st.mysqlconn;

import md.st.dao.DaoFactory;
import md.st.dao.GenericDao;
import md.st.dao.GeneralException;
import md.st.entity.Group;
import md.st.entity.Student;
import md.st.entity.Course;
import md.st.entity.Address;
import md.st.mysqlconn.MySqlGroupDao;
import md.st.mysqlconn.MySqlStudentDao;
import md.st.mysqlconn.MySqlCourseDao;
import md.st.mysqlconn.MySqlAddressDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory<Connection> {

	private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost:3306/studentsdb";
    private String driver = "com.mysql.jdbc.Driver";
    private Map<Class, DaoCreator> creators;

    public Connection getContext() throws GeneralException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new GeneralException(e);
        }
        return  connection;
    }

    @Override
    public GenericDao getDao(Connection connection, Class dtoClass) throws GeneralException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new GeneralException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);//se inregistreaza driver-ul
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();
        creators.put(Group.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlGroupDao(connection);
            }
        });
        creators.put(Student.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlStudentDao(connection);
            }
        });
        creators.put(Course.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlCourseDao(connection);
            }
        });
        creators.put(Address.class, new DaoCreator<Connection>() {
            @Override
            public GenericDao create(Connection connection) {
                return new MySqlAddressDao(connection);
            }
        });
       
        
    }
}
