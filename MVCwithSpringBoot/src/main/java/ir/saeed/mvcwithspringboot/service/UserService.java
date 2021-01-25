package ir.saeed.mvcwithspringboot.service;

import java.util.List;

import ir.saeed.mvcwithspringboot.entities.User;

public interface UserService {
	List<User> getAll();

	void save(User entity);

	User get(Integer id) throws Exception;

	void update(User entity);

	void delete(Integer id) throws Exception;

}
