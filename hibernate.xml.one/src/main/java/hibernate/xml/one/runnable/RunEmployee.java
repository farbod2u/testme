package hibernate.xml.one.runnable;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

import hibernate.xml.one.entities.Employee;

public class RunEmployee {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		try {
			Employee e = new Employee();
			e.setFirstName("Saeed");
			e.setLastName("Safaeian");
			session.save(e);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

		session.close();
		sessionFactory.close();
	}

}
