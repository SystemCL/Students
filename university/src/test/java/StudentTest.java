


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import md.st.university.dao.daos.StudentDao;
import md.st.university.dao.impl.StudentDaoImpl;
import md.st.university.dao.util.HibernateUtil;
import md.st.university.entity.Student;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/spring/StudentTest-context.xml")
public class StudentTest {  //classpath:/config/spring/app-context.xml

	@Autowired
	private static StudentDao studentBean;
	
	@Autowired
	private ApplicationContext appContext;
	
	//public static void main(String[] args) {
	@Test
	@Transactional(readOnly = true)
	public void test(){
		@SuppressWarnings("deprecation")

	//	appContext = new ClassPathXmlApplicationContext("/university/src/test/resources/md/st/university/model/dao/impl/StudentTest-context.xml");
		/*StudentDaoImpl studentDaoImpl = (StudentDaoImpl) studentBean;
		SessionFactory sessionFactory = studentDaoImpl.getSessionFactory();
		Session openSession = sessionFactory.getCurrentSession();
		Transaction transaction = openSession.beginTransaction();
*/
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student student = new Student();

		student.setFirstName("First name5");
		student.setLastName("Last name5");
		student.setAge(21);
		student.setEnrolment_date(null);

		studentBean.save(student);
	    //session.save(student);
	    session.getTransaction().commit();
		//transaction.commit();
	}	
	
	
/*	@Test
	public void testFindStudentInteger() {
		Student findStudent = studentBean.getStudentById(1);
		String c =  findStudent.getFirstName();
	System.out.println(c);
	}*/
	

		
		
/*		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student st = new Student();
		st = new Student().firstName("Ceucari").lastName("Adrian").age(21).enrolment_date(null).build();
		session.persist(st);*/
		
		/*Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();	
		Session session=factory.openSession();	
		
		Transaction t=session.beginTransaction();
		Student s1 = new Student();
		s1.firstName("Ceucari").lastName("Ivan").age(23).build();
	    session.save(s1);
		t.commit();
		session.close();
		factory.close();*/
		
		/*StudentDaoImpl userDaoImpl = (StudentDaoImpl) studentBean;
		SessionFactory sessionFactory = userDaoImpl.getSessionFactory();
		org.hibernate.Session openSession = sessionFactory.getCurrentSession();
		Transaction transaction = openSession.beginTransaction();
		
		Student student1 = new Student();
		
		student1 = new Student().firstName("Ceucari").lastName("Adrian").age(21).enrolment_date(null).build();
		dao.save(student1);*/
		//student1.build();
		/*Group gr = new Group();
		    gr = new Group().nomGroup("FAF-21").faculty("FTMIA").build();*/
	
	

	
}
