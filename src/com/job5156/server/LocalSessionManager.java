package com.job5156.server;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class LocalSessionManager {
	
	private static Log log = LogFactory.getLog(LocalSessionManager.class);
	private static final SessionFactory sessionFactory;
	
	/**静态块：创建session factory*/
	static {
		try {
			System.out.println("数据映射初始化...begin");
			//Configuration configure = new Configuration().configure();
			//sessionFactory = configure.buildSessionFactory();
			URL configFileURL =
					SessionManager.class.getResource("/Hibernate.cfg.xml");
			Configuration configure = (new Configuration()).configure(configFileURL);
//			configFileURL =
//				SessionManager.class.getResource("/hibernate.cfg.xml");
//			configure = configure.configure(configFileURL);
//
			sessionFactory =configure.buildSessionFactory();

			System.out.println("数据映射初始化...end");
		} catch (Throwable ex) {
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


	/**获取当前线程的session对象*/
	public static Session currentSession() throws HibernateException {
		Session s = sessionFactory.openSession();
		s.setFlushMode(FlushMode.NEVER);
		return s;
	}

	public static Session currentSessionFlush() throws HibernateException {
		Session s = sessionFactory.openSession();
		s.setFlushMode(FlushMode.AUTO);
		return s;
	}
	/**关闭当前线程所在的session对象*/
	public static void closeSession(Session s) throws HibernateException {
		if (s != null){
			s.close();
		}
	}
	
	
	/**
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		if(sessionFactory!=null){
			return sessionFactory;
		}
		else{
			System.out.println("无效的factiory");
			return null;
		}
	}
}
