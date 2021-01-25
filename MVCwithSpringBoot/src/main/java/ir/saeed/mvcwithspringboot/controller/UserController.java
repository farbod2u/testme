package ir.saeed.mvcwithspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ir.saeed.mvcwithspringboot.entities.User;
import ir.saeed.mvcwithspringboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String listAll(Model model) {
		List<User> list = service.getAll();
		model.addAttribute("data", list);
		return "listAll";
	}
	
	@GetMapping("/user/add")
	public String add(Model model) {
		
		return "user/add";
	}
}
