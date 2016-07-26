package md.st.university.dao.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
static{
		try {
			sessionFactory = ((Configuration) new AnnotationConfiguration()).configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed." + e);
		
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
}
