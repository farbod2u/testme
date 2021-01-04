package ir.saeed.hibernate.crud.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

import ir.saeed.hibernate.crud.entities.Student;

public class StudentDAO {
	private static Session session;
	private static SessionFactory sessionFactory;
	private static final Logger LOGGER = Logger.getLogger(StudentDAO.class);

	private static SessionFactory buildSessionFactory() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		// Create Metadata
		Metadata metadata = metadataSources.getMetadataBuilder().build();
		// Create SessionFactory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		return sessionFactory;
	}

	public static void create() {
		int count = 0;
		Student studentObj = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			for (int j = 101; j <= 105; j++) {
				count = count + 1;
				studentObj = new Student();
				studentObj.setName("Editor " + j);
				studentObj.setCourse("Bachelor Of Technology");
				session.save(studentObj);
			}

			session.getTransaction().commit();
			LOGGER.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				LOGGER.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				sessionFactory.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Student> read() {
		List<Student> res = new ArrayList<Student>();
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			res = session.createQuery("FROM Student").list();
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				LOGGER.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return res;
	}

	public static void update(Integer id) {
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			Student stuObj = (Student) session.get(Student.class, id);
			stuObj.setName("Java Code Geek");
			stuObj.setCourse("Masters Of Technology");

			session.getTransaction().commit();
			LOGGER.info("\nStudent With Id?= " + id + " Is Successfully Updated In The Database!\n");
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				LOGGER.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void delete(Integer id) {
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			Student studObj = findRecordById(id);
			session.delete(studObj);

			session.getTransaction().commit();
			LOGGER.info("\nStudent With Id?= " + id + " Is Successfully Deleted From The Database!\n");
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				LOGGER.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static Student findRecordById(Integer id) {
		Student res = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			res = (Student) session.load(Student.class, id);
		} catch (Exception sqlException) {
			if (null != session.getTransaction()) {
				LOGGER.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		}
		return res;
	}

}
