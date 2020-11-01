package com.springrest.springRest.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springRest.entity.Employee;
import com.springrest.springRest.services.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/home")
	public String home() {
		return "hello";
	}
	@GetMapping("/Employee")
	public List<Employee> getEmployee() {
		return this.service.getEmployee();
		
	}
	@GetMapping("/Employee/{empid}")
	public Employee getEmpId(@PathVariable String empid) {
		return this.service.getEmpId(empid);
	}
	
	@PostMapping("/Employee")
	public void addEmpId(@RequestBody Employee emp) {
		
		
	
		
	}
	


}
