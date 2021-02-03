package ir.saeed.multi.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.saeed.multi.EmployeeRepository;
import ir.saeed.multi.EmployeeService;
import ir.saeed.multi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> getAll() {
		return repository.getAll();
	}

	@Override
	public void batchInser() {
		List<Employee> res = new ArrayList<Employee>();
		res.add(new Employee(1, "saeed", "salam saeed"));
		res.add(new Employee(2, "ali", "salam ali"));
		res.add(new Employee(3, "vahid", "salam vahid"));
		//repository.saveAll(res);
	}

}
