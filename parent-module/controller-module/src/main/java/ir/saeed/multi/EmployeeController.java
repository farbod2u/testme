package ir.saeed.multi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ir.saeed.multi.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Integer id) {
		//service.delete(id);
	}
	
	@PutMapping("{id}")
	public void update(@PathVariable Integer id, @RequestParam(required = false) String name ,
			@RequestParam(required = false) String message) {
		//service.update(id, name, message);
	}
	
	@GetMapping("save")
	public String batchSave() {
		try {
			service.batchInsert();
			return "OK";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
