package com.springSecurity.springSecurityCheck;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/user")
	public String User() {
		return "user";
	}

	@RequestMapping("/admin")
	public String Admin() {
		return "admin";
	}

	@RequestMapping("/editor")
	public String Editor() {
		return "editor";
	}
	
	@RequestMapping("/403")
	public String NotFound() {
		return "notfound";
	}
}
