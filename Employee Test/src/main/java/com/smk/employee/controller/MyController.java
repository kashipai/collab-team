package com.smk.employee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smk.employee.entity.Employee;
import com.smk.employee.service.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	
	@GetMapping("/employee")
	public List<Employee> getEmployees()
	{
		return this.employeeservice.getEmployees();
	}
	
	@GetMapping("/employee/{Employeeid}")
	public Employee getEmployee(@PathVariable String Employeeid)
	{
		return this.employeeservice.getEmployee(Integer.parseInt(Employeeid));
	}
	
	@PostMapping("/employee")
	public Employee AddEmployee(@RequestBody Employee employee)
	{
		return this.employeeservice.AddEmployee(employee);
	}
	
	@DeleteMapping("/employee/{Employeeid}")
	private void deleteEmployee(@PathVariable("Employeeid") int empId) {
		employeeservice.deleteById(empId);
	}
	
	@PutMapping("/employee")
	private Employee update(@RequestBody Employee emp) {
		employeeservice.AddEmployee(emp);
		return emp;
	}

}
