package saeed.hibernate.runnable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import saeed.hibernate.entities.Student;

public class RunStudentClass {

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();

//		Transaction trans = session.beginTransaction();
//		try {
//			Student student = new Student();
//			student.setName("Saeed Safaeian");
//			session.save(student);
//			
//			trans.commit();
//		} catch (Exception e) {
//			trans.rollback();
//			e.printStackTrace();
//		}
		
		session.close();
		sessionFactory.close();
	}

}
