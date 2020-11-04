package com.sowjanya;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
	    List<Employee> listEmployees = service.listAll();
	    model.addAttribute("listEmployees", listEmployees);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewEmployeePage(Model model) {
	    Employee employee = new Employee();
	    model.addAttribute("employee", employee);
	     
	    return "new_employee";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	    service.save(employee);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_employee");
	    Employee employee = service.get(id);
	    mav.addObject("employee", employee);
	     
	    return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") Long id) {
	    service.delete(id);
	    return "redirect:/";       
	}
	
	@GetMapping("/403")
    public String error403() {
		return "403";
	}
	

}
