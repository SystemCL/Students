package md.st.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import md.st.dao.GenericDao;
import md.st.dao.Identified;
import md.st.entity.*;
import md.st.mysql.MySqlDaoFactory;
@RunWith(Parameterized.class)
public abstract class GenericDaoTest<Context> {
	 /**
     * Clasa pentru testare
     */
	protected Class daoClass;
	private Connection connection;
	private static final DaoFactory<Connection> factory = new MySqlDaoFactory();
	 /**
     * 
     */ 
    protected Identified notPersistedDto;

    /**
     *  Exemplar de obiect testabil dao
     */
    public abstract GenericDao dao();

    /**
     * Contextul de interactionare cu sistemul de BD
     */
    public abstract Context context();

    @Test
    public void testCreate() throws Exception {
        Identified dto = dao().create();

        Assert.assertNotNull(dto);
        Assert.assertNotNull(dto.getId());
    }
/////////////////////////////////////////////////////
    
 ///////////////////////////////////////////////////   
    @Test
    public void testPersist() throws Exception {
        Assert.assertNull("Id befor persist is not null.", notPersistedDto.getId());

        notPersistedDto = dao().persist(notPersistedDto);

        Assert.assertNotNull("After persist id is null.", notPersistedDto.getId());
    }

    @Test
    public void testGetByPK() throws Exception {
        Serializable id = dao().create().getId();
        Identified dto = dao().getByPK(id);
        Assert.assertNotNull(dto);
    }

    @Test
    public void testDelete() throws Exception {
        Identified dto = dao().create();
        Assert.assertNotNull(dto);

        List list = dao().getAll();
        Assert.assertNotNull(list);

        int oldSize = list.size();
        Assert.assertTrue(oldSize > 0);

        dao().delete(dto);

        list = dao().getAll();
        Assert.assertNotNull(list);

        int newSize = list.size();
        Assert.assertEquals(1, oldSize - newSize);
    }

    @Test
    public void testGetAll() throws Exception {
        List list = dao().getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
    }

    public GenericDaoTest(Class clazz, Identified<Integer> notPersistedDto) {
        this.daoClass = clazz;
        this.notPersistedDto = notPersistedDto;
    }

}
