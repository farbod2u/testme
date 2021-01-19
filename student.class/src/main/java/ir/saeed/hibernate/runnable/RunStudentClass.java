package ir.saeed.hibernate.runnable;

import java.util.GregorianCalendar;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import ir.saeed.hibernate.entities.Mark;
import ir.saeed.hibernate.entities.Person;
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
//			one_to_one(session);
//			one_to_many(session);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

		session.close();
		sessionFactory.close();
	}

	private static void one_to_many(Session session) {
		// *************** insert into one-to-many ****************
		Student student = session.load(Student.class, 1);
		
		Mark mark = new Mark();
		mark.setValue(12f);
		mark.setStudent(student);
		student.getMarks().add(mark);
		
		mark = new Mark();
		mark.setValue(20f);
		mark.setStudent(student);
		student.getMarks().add(mark);
		
		session.saveOrUpdate(student);


		// *************** read from one-to-many ****************
		Student student2 = session.load(Student.class, 1);
		System.out.println(student2.getFullName());
		student2.getMarks().forEach(new Consumer<Mark>() {

			public void accept(Mark t) {
				System.out.println(t.getValue());

			}
		});
	}

	private static void one_to_one(Session session) {
		// ************** insert into one-to-one ***************
		Person person = new Person();
		person.setFirstName("Ali");
		person.setLastName("Safaeian");
		person.setBirthDate(new GregorianCalendar(1978, 8, 11).getTime());
		session.save(person);

		Student student = new Student();
		student.setStudentNumber("456");
		student.setEntranceYear((short) 1380);
		student.setPerson(person);

		person.setStudent(student);
		session.saveOrUpdate(person);

		// *************** read from one-to-one ****************
		Person person2 = session.load(Person.class, 1);
		System.out.println(person2.getStudent().getStudentNumber());
	}

}
