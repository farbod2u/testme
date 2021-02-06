package ir.saeed.multi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.saeed.multi.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("{id}")
	public Employee get(@PathVariable Integer id) throws Exception {
		return service.get(id);
	}

	@GetMapping
	public List<Employee> getAll() {
		return service.getAll();
	}

	@PostMapping
	public void save(@Valid @RequestBody Employee entity) throws Exception {
		service.save(entity);
	}

//	@PutMapping("{id}")
//	public void update(@PathVariable Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String message) throws Exception {
//		service.update(new Employee(id, name, message));
//	}

	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @Valid @RequestBody Employee entity) throws Exception {
		entity.setId(id);
		service.update(entity);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) throws Exception {
		service.delete(id);
	}

}
