package ir.saeed.mvcwithspringboot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.saeed.mvcwithspringboot.entities.User;
import ir.saeed.mvcwithspringboot.repository.UserRepository;
import ir.saeed.mvcwithspringboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.getAll();
	}

	@Transactional
	@Override
	public void save(User entity) {
		repository.save(entity);
	}

	@Override
	public User get(Integer id) throws Exception {
		return repository.get(id);
	}

	@Transactional
	@Override
	public void update(User entity) {
		repository.update(entity);
	}

	@Transactional
	@Override
	public void delete(Integer id) throws Exception {
		repository.delete(id);
	}

}
