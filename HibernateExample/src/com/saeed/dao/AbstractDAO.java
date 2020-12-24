package com.saeed.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {

	protected Session session;
	protected static SessionFactory sessionFactory;

	public AbstractDAO() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		}

		session = sessionFactory.openSession();
	}

	public void close() {
		session.close();
		sessionFactory.close();
	}

}
