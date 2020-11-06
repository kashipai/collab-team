package com.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class TestController {
	
	@RequestMapping("/")
	public ModelAndView defaultHome() {
		return new ModelAndView("admin");
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		 return new ModelAndView("login");
	}
	
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
    	return new ModelAndView("403");

    }

}