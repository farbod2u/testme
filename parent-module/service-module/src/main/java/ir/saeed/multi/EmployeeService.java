package ir.saeed.multi;

import java.util.List;

import ir.saeed.multi.model.Employee;

public interface EmployeeService {
	List<Employee> getAll();

	void save(Employee entity);

	void batchInser();
}
