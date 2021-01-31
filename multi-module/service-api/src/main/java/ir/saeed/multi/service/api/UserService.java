package ir.saeed.multi.service.api;

import java.util.List;

import ir.saeed.multi.model.User;

public interface UserService {
	List<User> getAll();

	void save(User entity) throws Exception;

	User get(Integer id) throws Exception;

	void update(User entity) throws Exception;

	void delete(Integer id) throws Exception;

}
