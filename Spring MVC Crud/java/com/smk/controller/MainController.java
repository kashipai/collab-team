package com.smk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smk.*;
import com.smk.dao.EmployeeDao;
import com.smk.dto.Employee;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeDao empdao;
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
	    List<Employee> listContact = empdao.list();
	    model.addObject("listContact", listContact);
	    System.out.println(listContact);
	    System.out.println("Working");
	    model.setViewName("home");
	    
	 
	    return model;
	}
	
	@ResponseBody
	@RequestMapping("/yes")
	public String sumne()
	{
		return "This is Sumne";
	}
	
	@RequestMapping(value ="/newContact", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
	    Employee emp = new Employee();
	    model.addObject("employee", emp);
	    System.out.println("Ok");
	    model.setViewName("ContactForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Employee employee) {
	    empdao.saveOrUpdate(employee);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
	public ModelAndView deleteContact(HttpServletRequest request) {
		System.out.println(request.getParameter("employeeid"));
		int contactId = Integer.parseInt(request.getParameter("employeeid"));
		empdao.delete(contactId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editContact", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		System.out.println("Fetched is "+request.getParameter("employeeid"));
	    int contactId = Integer.parseInt(request.getParameter("employeeid"));
	    Employee employee = empdao.get(contactId);
	    ModelAndView model = new ModelAndView("ContactForm");
	    model.addObject("employee", employee);
	 
	    return model;
	}

}
