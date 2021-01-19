package ir.saeed.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/saeed")
	public String saeed() {
		return "saeed";
	}
}
