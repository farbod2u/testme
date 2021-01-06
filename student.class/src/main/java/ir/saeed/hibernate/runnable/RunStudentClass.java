package ir.saeed.hibernate.runnable;

import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import ir.saeed.hibernate.entities.Mark;
import ir.saeed.hibernate.entities.Student;

public class RunStudentClass {

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();

		Transaction trans = session.beginTransaction();
		try {
			Student student = session.load(Student.class, 1); //new Student();
			student.getMarks().forEach(new Consumer<Mark>() {

				public void accept(Mark t) {
					System.out.println(t.getValue());
					
				}
			});
			
			//student.setAge(23f);
			//Mark mark = new Mark();
			//mark.setValue(12f);
			//mark.setStudent(student);
			//student.getMarks().add(mark);
			//session.save(student);
			//session.save(mark);
			
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

		session.close();
		sessionFactory.close();
	}

}
