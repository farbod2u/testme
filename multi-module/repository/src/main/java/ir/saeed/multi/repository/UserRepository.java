package ir.saeed.multi.repository;

import java.util.List;

import ir.saeed.multi.model.User;

public interface UserRepository {

	List<User> getAll();

	void save(User entity) throws Exception;

	User get(Integer id) throws Exception;

	void update(User entity) throws Exception;

	void delete(Integer id) throws Exception;

}
