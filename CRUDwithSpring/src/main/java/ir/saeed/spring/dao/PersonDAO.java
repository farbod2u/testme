package ir.saeed.spring.dao;

import ir.saeed.spring.entities.Person;

public interface PersonDAO {
	Integer create(Person entity);

	Person read(Integer id);
}
