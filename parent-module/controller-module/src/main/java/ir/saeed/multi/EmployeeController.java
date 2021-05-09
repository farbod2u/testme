package ir.saeed.multi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

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

	@GetMapping(headers = "X-API-Version=1")
	public MappingJacksonValue getAll1() {
		List<Employee> res = service.getAll();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept();
		FilterProvider filters = new SimpleFilterProvider().addFilter("SaeedBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(res);
		mapping.setFilters(filters);
		
		return mapping;
	}

	@GetMapping(headers = "X-API-Version=2")
	public MappingJacksonValue getAll2() {	
		List<Employee> res = service.getAll();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("message");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SaeedBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(res);
		mapping.setFilters(filters);

		return mapping;
	}
	
	@GetMapping(produces = "application/ir.saeed.app-v3+json")
	public MappingJacksonValue getAll3() {
		List<Employee> res = service.getAll();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("message");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SaeedBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(res);
		mapping.setFilters(filters);
		
		return mapping;
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
