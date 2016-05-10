package org.hibernate.init;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.dao.UserDetails;

public class HibernateInitializer {
	
	private static SessionFactory factory ;
	
	public static void main(String[] args) {
		
		HibernateInitializer.simpleInsert();
	
		HibernateInitializer.simpleRetriveUserDetails();
	}
	
	
	private static void simpleInsert(){
		UserDetails user = new UserDetails();
		
		user.setUserId(1);
		user.setUserName("First user");
		
		factory = HibernateInitializer.getSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction trans = session.beginTransaction();
		// Insert Data 
		session.save(user);
		trans.commit();
		session.close();
	}
	
	
	private  static void simpleRetriveUserDetails(){
		UserDetails user ;
		factory = HibernateInitializer.getSessionFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		user = (UserDetails) session.get(UserDetails.class, 1);
		if(user != null){
			System.out.println("User Name is : "+user.getUserName());
			System.out.println("User ID is : "+user.getUserId());
		}else{
			System.out.println("User Not Found");
		}
		
		
	}
	
	private static  SessionFactory getSessionFactory(){
		if(factory == null  ){
			return new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	

}
