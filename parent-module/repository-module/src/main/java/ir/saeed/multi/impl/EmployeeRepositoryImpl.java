package ir.saeed.multi.impl;

import java.util.List;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ir.saeed.multi.EmployeeRepository;
import ir.saeed.multi.model.Employee;

@Repository
@Primary
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private EntityManagerFactory emFactory;

	private Session session;

	private Session getSession() {
		if (emFactory.unwrap(SessionFactory.class) == null)
			throw new NullPointerException("factory is not a hibernate factory");

		if (session == null)
			session = emFactory.unwrap(SessionFactory.class).openSession();

		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		return getSession().createQuery("from Employee").list();
	}

	@Override
	public void save(Employee entity) {
		Transaction trans = this.getSession().beginTransaction();
		try {
			this.getSession().save(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
