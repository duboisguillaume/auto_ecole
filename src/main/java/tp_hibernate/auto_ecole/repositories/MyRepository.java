package tp_hibernate.auto_ecole.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import tp_hibernate.auto_ecole.utils.SessionHibernate;

public abstract class MyRepository<T> {

	
	public void save(T t) {
		Session s = SessionHibernate.currentSession();
		s.beginTransaction();
		s.save(t);
		s.getTransaction().commit();
		SessionHibernate.closeSession();
	}

	public T get(int i, Class<T> type) {
		Session s = SessionHibernate.currentSession();
		return s.get(type, i);
	}

	public List<T> getAll(Class<T> type) {
		Session s = SessionHibernate.currentSession();
		System.out.println(type.getSimpleName());
		TypedQuery<T> q =s.createNamedQuery(type.getSimpleName()+".findAll", type);
		List<T> l = q.getResultList();
		return l;
	}
	
	public void update(T object){
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }
	
    public void delete(T object) {
        Session session = SessionHibernate.currentSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        SessionHibernate.closeSession();
    }

}
