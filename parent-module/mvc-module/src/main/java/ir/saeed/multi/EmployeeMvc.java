package ir.saeed.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeMvc {

	@Autowired
	EmployeeService service;

	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("data", service.getAll());
		return "listAll";
	}
}
