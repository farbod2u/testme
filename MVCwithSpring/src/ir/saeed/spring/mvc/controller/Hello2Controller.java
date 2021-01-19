package ir.saeed.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello2Controller {

	@RequestMapping("/hello2")
	public String hello2(Model model) {
		model.addAttribute("msg", "salam saeed");
		return "hello2";
	}
}
