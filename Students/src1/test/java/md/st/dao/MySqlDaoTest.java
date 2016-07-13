package md.st.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;

import md.st.dao.GenericDaoTest;
import md.st.dao.DaoFactory;
import md.st.dao.GenericDao;
import md.st.dao.Identified;
import md.st.dao.PersistException;
import md.st.entity.Address;
import md.st.entity.Course;
import md.st.entity.Group;
import md.st.entity.Student;
import md.st.mysql.MySqlDaoFactory;

public class MySqlDaoTest extends GenericDaoTest<Connection> {
	private Connection connection;

    private GenericDao dao;

    private static final DaoFactory<Connection> factory = new MySqlDaoFactory();

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {Group.class, new Group()},
                {Student.class, new Student()},
                {Course.class, new Course()}, 
                {Address.class, new Address()},
                
        });
    }

    @Before
    public void setUp() throws PersistException, SQLException {
        connection = factory.getContext();
        connection.setAutoCommit(false);
        dao = factory.getDao(connection, daoClass);
    }

    @After
    public void tearDown() throws SQLException {
        context().rollback();
        context().close();
    }

    @Override
    public GenericDao dao() {
        return dao;
    }

    @Override
    public Connection context() {
        return connection;
    }

    public MySqlDaoTest(Class clazz, Identified<Integer> notPersistedDto) {
        super(clazz, notPersistedDto);
    }

}
