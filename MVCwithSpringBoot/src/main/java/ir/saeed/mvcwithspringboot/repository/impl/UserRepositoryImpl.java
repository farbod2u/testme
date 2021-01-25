package ir.saeed.mvcwithspringboot.repository.impl;

import java.util.List;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ir.saeed.mvcwithspringboot.entities.User;
import ir.saeed.mvcwithspringboot.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManagerFactory emFactory;

	private Session getSession() {
		if (emFactory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		return emFactory.unwrap(SessionFactory.class).openSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		List<User> res = this.getSession().createQuery("from User").list();
		return (res != null ? (res.size() > 0 ? res : null) : null);
	}

	@Override
	public void save(User entity) {
		this.getSession().save(entity);
	}

	@Override
	public User get(Integer id) throws Exception {
		return this.getSession().get(User.class, id);
	}

	@Override
	public void update(User entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(Integer id) throws Exception {
		this.getSession().delete(this.get(id));
	}

}
