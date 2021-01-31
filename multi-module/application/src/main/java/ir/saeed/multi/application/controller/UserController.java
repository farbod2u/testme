package ir.saeed.multi.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ir.saeed.multi.model.User;
import ir.saeed.multi.service.api.UserService;

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
		model.addAttribute("data", new User());
		return "user/add_edit";
	}

	@GetMapping("/user/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		try {
			model.addAttribute("data", service.get(id));
			return "user/add_edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}

	@PostMapping("/user/save")
	public String add(@ModelAttribute User entity, Model model) {
		try {
			if (entity.getId() == null)
				service.save(entity);
			else
				service.update(entity);
		} catch (Exception e) {

		}

		return "redirect:/";
	}

	@GetMapping("/user/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		try {
			service.delete(id);
		} catch (Exception e) {

		}

		return "redirect:/";
	}

}
