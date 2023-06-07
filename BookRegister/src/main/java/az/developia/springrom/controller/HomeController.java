package az.developia.springrom.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.springrom.util.MyUtil;

@Controller
public class HomeController {

	@Autowired
	private MyUtil myUtil;

	@GetMapping
	public String showHome(Model m) {

		m.addAttribute("loggedInUsername", myUtil.findUser());

		return "home";
	}
	
	@GetMapping(path="/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		
		return "my-login";
	}
	
}
