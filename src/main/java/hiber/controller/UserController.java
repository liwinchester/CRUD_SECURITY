package hiber.controller;


import hiber.dto.RolesDTO;
import hiber.model.Role;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/")
	public String listUsers(Model model){
		model.addAttribute("listUsers", userService.listUser());
		return "users";
	}


	@GetMapping("/add")
	public String create(Model model){
		model.addAttribute("user", new User());
		model.addAttribute("userRoles", userService.listRoles());
		return "add";
	}
	@PostMapping("/save")
	public String createUser(@ModelAttribute("user") User user){
		userService.addUser(user);
		return "redirect:/";
	}
	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") long id){
		this.userService.removeUser(id);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") long id, Model model){
		User user =  userService.getUserById(id);
		model.addAttribute("user", user);
		return "edit";
	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user){
		userService.updateUser(user);
		return "redirect:/";
	}

}
