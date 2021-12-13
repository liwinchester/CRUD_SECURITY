package hiber.controller;


import hiber.model.User;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
		User user = new User();
		model.addAttribute("user", user);
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
