package ir.saeed.mvcwithspringboot.repository.impl;

import java.util.List;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ir.saeed.mvcwithspringboot.entities.User;
import ir.saeed.mvcwithspringboot.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

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
	public List<User> getAll() {
		List<User> res = this.getSession().createQuery("from User").list();
		return (res != null ? (res.size() > 0 ? res : null) : null);
	}

	@Override
	public void save(User entity) {
		Transaction trans = this.getSession().beginTransaction();
		try {
			this.getSession().save(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public User get(Integer id) throws Exception {
		return this.getSession().get(User.class, id);
	}

	@Override
	public void update(User entity) {
		Transaction trans = this.getSession().beginTransaction();
		try {
			User origEntity = this.getSession().load(User.class, entity.getId());
			origEntity.setUserName(entity.getUserName());
			origEntity.setPassword(entity.getPassword());
			this.getSession().update(origEntity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		Transaction trans = this.getSession().beginTransaction();

		try {
			User origEntity = this.getSession().load(User.class, id);
			this.getSession().delete(origEntity);
			trans.commit();

		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
