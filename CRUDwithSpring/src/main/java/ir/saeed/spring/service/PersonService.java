package ir.saeed.spring.service;

import ir.saeed.spring.entities.Person;

public interface PersonService {
	Integer create(Person entity);

	Person read(Integer id);
}
