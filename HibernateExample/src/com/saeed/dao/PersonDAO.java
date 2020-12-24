package com.saeed.dao;

import org.hibernate.Transaction;

import com.saeed.entities.Person;

public class PersonDAO extends AbstractDAO {

	public Integer save(Person entity) throws Exception {
		Integer res = -1;
		Transaction trans = session.beginTransaction();
		try {
			res = (Integer) session.save(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			System.err.println(e);
			throw e;
		}
		session.close();
		return res;
	}

	public void update(Person entity) throws Exception {
		if (entity.getId() == null)
			throw new Exception("Please set primary key.");

		session = PersonDAO.sessionFactory.openSession();
		
		Transaction trans = session.beginTransaction();
		try {
			session.update(entity);
			//session.merge(entity);
			//session.saveOrUpdate(entity);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			System.err.println(e);
			throw e;
		}
		session.close();
	}
}
