package ir.saeed.multi;

import java.util.List;

import ir.saeed.multi.model.Employee;

public interface EmployeeRepository {
	List<Employee> getAll();

	void save(Employee entity);
}
