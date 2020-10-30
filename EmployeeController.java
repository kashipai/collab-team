package com.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.model.Employee;
import com.springBoot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee")
	private List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{empId}")
	private Employee getEmployees(@PathVariable("empId") int empId) {
		return employeeService.getById(empId);
	}

	@DeleteMapping("/employee/{empId}")
	private void deleteEmployee(@PathVariable("empId") int empId) {
		employeeService.deleteById(empId);
	}

	@PostMapping("/employee")
	private int saveEmployee(@RequestBody Employee emp) {
		employeeService.saveOrUpdate(emp);
		return emp.getEmpId();
	}

	@PutMapping("/employee")
	private Employee update(@RequestBody Employee emp) {
		employeeService.saveOrUpdate(emp);
		return emp;
	}
}
