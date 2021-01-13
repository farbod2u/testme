package ir.saeed.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.saeed.spring.dao.PersonDAO;
import ir.saeed.spring.entities.Person;
import ir.saeed.spring.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO dao;
	
	@Transactional
	public Integer create(Person entity) {
		return dao.create(entity);
	}

	public Person read(Integer id) {
		return dao.read(id);
	}

}
