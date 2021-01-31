package ir.saeed.multi.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ir.saeed.multi.model.User;
import ir.saeed.multi.repository.UserRepository;
import ir.saeed.multi.service.api.UserService;
import ir.saeed.multi.service.api.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.getAll();
	}

	@Override
	public void save(User entity) throws Exception {
		try {
			repository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User get(Integer id) throws Exception {
		User res = null;
		try {
			res = repository.get(id);
			if (res == null)
				throw new UserNotFoundException(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return res;
	}

	@Override
	public void update(User entity) throws Exception {
		try {
			repository.update(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(Integer id) throws Exception {
		try {
			repository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
