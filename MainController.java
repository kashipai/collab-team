package com.manager.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.manager.employee.dao.EmployeeDAO;
import com.manager.employee.model.Employee;

@Controller
public class MainController {
	@Autowired
	private EmployeeDAO empDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) {
		List<Employee> list = empDAO.list();
		model.addObject("list", list);
		model.setViewName("index");
		return model;
		
	}
	
	@RequestMapping(value = "/newform", method= RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee emp = new Employee();
		model.addObject("emp", emp);
		model.setViewName("newform");
		return model;
		
	}
	
	@RequestMapping(value = "/save", method= RequestMethod.POST)
	public ModelAndView SaveEmployee(@ModelAttribute Employee employee) {
		empDAO.save(employee);
		return new ModelAndView("redirect:/");
		
	}
	@RequestMapping(value = "/edit", method= RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest req) {
		String empid = req.getParameter("empid");
		Employee emp = empDAO.get(empid);
		ModelAndView model = new ModelAndView("newform");
		model.addObject("emp", emp);
		
		return model;
		
	}
	@RequestMapping(value = "/delete", method= RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam String empid) {
		empDAO.delete(empid);
		return  new ModelAndView("redirect:/");
		
	}
}
