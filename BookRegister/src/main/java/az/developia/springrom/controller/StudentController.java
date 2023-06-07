package az.developia.springrom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/students")
public class StudentController {

	@GetMapping
	public String showStudents() {
		return "students";
	}
}