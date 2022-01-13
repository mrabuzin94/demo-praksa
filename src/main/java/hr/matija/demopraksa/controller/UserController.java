package hr.matija.demopraksa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hr.matija.demopraksa.domain.User;
import hr.matija.demopraksa.manager.UserManager;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	private final UserManager userManager;

	public UserController(UserManager userManager) {
		this.userManager = userManager;
	}

	@GetMapping("/create")
	private String showUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user-create";
	}

	@PostMapping("/create")
	private String saveUser(@ModelAttribute User user) {
		userManager.createUser(user);
		return "redirect:/user/list";
	}

	@RequestMapping("/list")
	private String getAllUsers(Model model) {
		List<User> allUsers = userManager.findAllUsers();
		model.addAttribute("users", allUsers);
		return "user-list";
	}

	@RequestMapping("/info/{userId}")
	private String getUserInfo(Model model, @PathVariable Long userId) {
		Optional<User> optionalUser = userManager.getUser(userId);
		if(optionalUser.isPresent()) {
			model.addAttribute("user", optionalUser.get());
			return "user-info";
		}
		return "redirect:/user/list";
	}

	@RequestMapping("/delete/{userId}")
	private String deleteUser(@PathVariable Long userId) {
		userManager.deleteUserById(userId);
		return "redirect:/user/list";
	}
}
