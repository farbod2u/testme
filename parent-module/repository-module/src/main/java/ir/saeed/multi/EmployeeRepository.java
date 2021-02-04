package ir.saeed.multi;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ir.saeed.multi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/*List<Employee> getAll();

	void save(Employee entity);*/
	
	@Query("select e from Employee e where e.name = ?1")
	Optional<Employee> findEmployeeByName(String name);
}
