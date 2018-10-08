package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login.do")
public class LoginController {

	@GetMapping
	public void getHandle() {
		System.out.println("LoginController.getHandle()");
	}
	
	@PostMapping
	public void postHandle() {
		System.out.println("LoginController.postHandle()");
	}
}
