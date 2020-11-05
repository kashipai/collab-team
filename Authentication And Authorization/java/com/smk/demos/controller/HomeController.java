package com.smk.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/user")
	public String userpage()
	{
		return "user.jsp";
	}
	
	@RequestMapping("/admin")
	public String adminpage()
	{
		return "admin.jsp";
	}
	
	@RequestMapping("/403")
	public String errorpage()
	{
		return "denied.jsp";
	}

}
