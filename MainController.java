package com.sowjanya.spring.Employee.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sowjanya.spring.Employee.dao.EmployeeDAO;
import com.sowjanya.spring.Model.Employee;

@Controller
public class MainController {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping(value="/")
	public ModelAndView listEmployee(ModelAndView model) {
		List<Employee> listEmployee=employeeDAO.list();
		model.addObject("listEmployee",listEmployee);
		model.setViewName("index");
		
		return model;
		
	}
	
	@RequestMapping(value="/new" ,method=RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
		Employee newEmployee=new Employee();
		model.addObject("employee",newEmployee);
		model.setViewName("employee_form");
		
		return model;
		
	}
	
	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeDAO.save(employee);
		
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping(value="/edit" ,method=RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request ) {
		int id=Integer.parseInt(request.getParameter("id"));
		Employee employee=employeeDAO.get(id);
		ModelAndView model=new ModelAndView("employee_form");
		model.addObject("employee",employee );
		
		return model;
		
	}
	
	@RequestMapping(value="/delete" ,method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam int id ) {
	   employeeDAO.delete(id);
	   return new ModelAndView("redirect:/");
		
		
	}
}
