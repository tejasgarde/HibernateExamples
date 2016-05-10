package org.hibernate.init;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.dao.UserDetails;

public class HibernateInitializer {
	
	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		user.setUserId(1);
		user.setUserName("First user");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		
		session.save(user);
		trans.commit();
		
		
		
		
		
	}

}
