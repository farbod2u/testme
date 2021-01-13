package ir.saeed.spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import ir.saeed.spring.dao.PersonDAO;
import ir.saeed.spring.entities.Person;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Integer create(Person entity) {
		return (Integer) hibernateTemplate.save(entity);
	}

	public Person read(Integer id) {
		return hibernateTemplate.get(Person.class, id);
	}

}
