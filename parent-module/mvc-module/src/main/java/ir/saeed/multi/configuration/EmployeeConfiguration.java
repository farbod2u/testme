package ir.saeed.multi.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ir.saeed.multi.EmployeeService;
import ir.saeed.multi.model.Employee;

@Configuration
public class EmployeeConfiguration {

	@Bean
	CommandLineRunner commandLineRunner(EmployeeService service) {
		return args ->{
			Employee entity = new Employee();
			entity.setMessage("wwww");
			entity.setName("wrty");
			service.save(entity);
		};
	}
}
