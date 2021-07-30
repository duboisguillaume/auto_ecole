package tp_hibernate.auto_ecole.utils;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionHibernate {
	public static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
	public static SessionFactory sessionFactory;
	private static StandardServiceRegistry serviceRegistry;
	
	static {
		try {
			System.out.println(new Date() + " : Initialisation de la session");
			Configuration configuration = new Configuration().configure();
			serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static Session currentSession() {
		System.out.println("Je recup�re ma session");
		Session s = threadSession.get();
		if(s == null) {
			s = sessionFactory.openSession();
			threadSession.set(s);
		}
		System.out.println(s);
		return s;
	}
	
	public static void closeSession() {
		Session s = threadSession.get();
		if(s != null) s.close();
		threadSession.set(null);
		System.out.println("session ferm�");
	}
}

