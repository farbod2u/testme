package ir.saeed.hibernate.crud.main;

import java.util.List;

import org.apache.log4j.Logger;

import ir.saeed.hibernate.crud.dao.StudentDAO;
import ir.saeed.hibernate.crud.entities.Student;

public class RunCrud {

	public final static Logger logger = Logger.getLogger(RunCrud.class);

	public static void main(String[] args) {
		logger.info(".......Hibernate Crud Operations Example.......\n");

		// logger.info("\n=======CREATE RECORDS=======\n");
		// StudentDAO.create();

		logger.info("\n=======READ RECORDS=======\n");
		List<Student> viewStudents = StudentDAO.read();
		if (viewStudents != null & viewStudents.size() > 0) {
			for (Student studentObj : viewStudents)
				logger.info(studentObj.toString());
		}

		logger.info("\n=======UPDATE RECORDS=======\n");
		StudentDAO.update(1);
		logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
		List<Student> updateStudent = StudentDAO.read();
		if (updateStudent != null & updateStudent.size() > 0) {
			for (Student studentObj : updateStudent)
				logger.info(studentObj.toString());
		}

		logger.info("\n=======DELETE RECORD=======\n");
		StudentDAO.delete(5);
		logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
		List<Student> deleteStudentRecord = StudentDAO.read();
		for (Student studentObj : deleteStudentRecord)
			logger.info(studentObj.toString());

		System.exit(0);
	}

}
