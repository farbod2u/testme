package ir.saeed.multi.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ir.saeed.multi.EmployeeRepository;
import ir.saeed.multi.EmployeeService;
import ir.saeed.multi.exception.ApiRequestException;
import ir.saeed.multi.exception.EntityNotFoundException;
import ir.saeed.multi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void save(Employee entity) throws Exception {
		Optional<Employee> res = repository.findEmployeeByName(entity.getName());
		if (res.isPresent())
			throw new ApiRequestException("Name already exits!");
		repository.save(entity);
	}

	@Override
	@Transactional
	public void update(Employee entity) throws Exception {
		if (entity.getId() == null)
			throw new ApiRequestException("ID should not be Null.");
		Optional<Employee> orig = repository.findById(entity.getId());
		if (orig.isEmpty())
			throw new EntityNotFoundException(entity.getId());
		Optional<Employee> res = repository.findEmployeeByName(entity.getName());
		if (res.isPresent() && res.get().getId() != entity.getId())
			throw new ApiRequestException("Name already exits!");

		orig.get().setName(entity.getName());
		orig.get().setMessage(entity.getMessage());
		repository.save(orig.get());
	}

	@Override
	public void delete(Integer id) throws Exception {
		if (repository.existsById(id))
			repository.deleteById(id);
		else
			throw new EntityNotFoundException(id);
	}

	@Override
	public Employee get(Integer id) throws Exception {
		Optional<Employee> res = repository.findById(id);
		if (res.isEmpty())
			throw new EntityNotFoundException(id);

		return res.get();
	}

}
