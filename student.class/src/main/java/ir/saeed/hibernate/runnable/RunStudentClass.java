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
//**************  insert into one-to-one	***************	
//			Person person = new Person();
//			person.setFirstName("Saeed");
//			person.setLastName("Safaeian");
//			person.setBirthDate(new GregorianCalendar(1978, 8, 11).getTime());
//			session.save(person);	
//			Student student = new Student();
//			student.setStudentNumber("3333");
//			student.setEntranceYear((short) 234);
//			student.setPerson(person);
//			person.setStudent(student);
//			session.saveOrUpdate(person);
//***************   read from one-to-one	****************	
//			Person person = session.load(Person.class, 1);
//			System.out.println(person.getStudent().getStudentNumber());
			
			

//			Student student = session.load(Student.class, 1); //new Student();
//			student.getMarks().forEach(new Consumer<Mark>() {
//
//				public void accept(Mark t) {
//					System.out.println(t.getValue());
//					
//				}
//			});

			// student.setAge(23f);
			// Mark mark = new Mark();
			// mark.setValue(12f);
			// mark.setStudent(student);
			// student.getMarks().add(mark);
			// session.save(student);
			// session.save(mark);

			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}

		session.close();
		sessionFactory.close();
	}

}
