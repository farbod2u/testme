package ir.saeed.mvcwithspringboot.repository;

import java.util.List;

import ir.saeed.mvcwithspringboot.entities.User;

public interface UserRepository {

	List<User> getAll();

	void save(User entity);

	User get(Integer id) throws Exception;

	void update(User entity);

	void delete(Integer id) throws Exception;

}
