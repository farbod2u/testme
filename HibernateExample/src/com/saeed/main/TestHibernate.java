package com.saeed.main;

import com.saeed.dao.PersonDAO;
import com.saeed.entities.Person;

public class TestHibernate {

	public static void main(String[] args) {
		PersonDAO personDAO = new PersonDAO();
		Person person = new Person();
//		person.setFirstName("6622");
//		person.setLastName("eee");
//		person.setActive(false);
//		try {
//			System.out.println(personDAO.save(person));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		person.setFatherName("saeed");
//		try {
//			personDAO.update(person);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//personDAO.close();
		
		
		// File file = new File("src/example/main/hibernate.cfg.xml");
		// org.hibernate.cfg.Configuration configuration = new
		// Configuration().configure(file);

//		Configuration configuration = new Configuration().configure();
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//		Session session = sessionFactory.openSession();
//
//		Transaction trans = session.beginTransaction();
//		try {
//			Student student = new Student();
//			student.setId(2);
//			student.setName("کاوه");
//			student.setEmailAddress("ssss");
//
//			session.saveOrUpdate(student);
//			trans.commit();
//		} catch (Exception e) {
//			System.err.println(e);
//			trans.rollback();
//		}
//		
//		Person person = new Person();
//		person.setFirstName("سعید");
//		person.setLastName("صفائیان");
//		person.setActive(true);
//		//person.setFatherName("محمد تقی");
//		session.saveOrUpdate(person);
//
//		
//		session.close();
//		sessionFactory.close();
	}

}
