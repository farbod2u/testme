package ir.saeed.multi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.saeed.multi.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/api/employee")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/api/save")
	public String batchSave() {
		try {
			service.batchInser();
			return "OK";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
