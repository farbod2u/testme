package ir.saeed.multi;

import java.util.List;

import ir.saeed.multi.model.Employee;

public interface EmployeeService {

	Employee get(Integer id) throws Exception;

	List<Employee> getAll();

	void save(Employee entity) throws Exception;

	void update(Employee entity) throws Exception;

	void delete(Integer id) throws Exception;

}
