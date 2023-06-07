package az.developia.springrom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springrom.model.UserModel;
import az.developia.springrom.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {


	@Autowired
	private UserService userService;

	@GetMapping(path = "/open-my-login")
	public String openMyLogin() {
		return "my-login";
	}

	@GetMapping(path = "/open-signup")
	public String openSignup(Model m) {

		m.addAttribute("user", new UserModel());

		return "save-user";
	}

	@PostMapping(path = "/save")

	public String saveUser(@Valid @ModelAttribute(name = "user") UserModel user, BindingResult br, Model m) {

		if (br.hasErrors()) {

			return "save-user";
		}
		userService.saveUser(user);

		return "redirect:/users/open-my-login";
	}
	
	
	
	@GetMapping(path = "/all")
	@PreAuthorize(value = "hasAuthority('users:get:all')")
	public String openAll(Model m) {
List<UserModel> users =userService.findAll();

		
		m.addAttribute("users", users);

		return "user-list";
	}
	
	

}
