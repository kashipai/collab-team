package com.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.model.Employee;
import com.springBoot.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = repository.findAll();
		return employees;
	}

	public Employee saveOrUpdate(Employee emp) {
		return repository.save(emp);

	}

	public Employee getById(int empId) {
		return repository.findById(empId).get();
	}

	public boolean deleteById(int id) {
		repository.deleteById(id);
		return true;
	}

	public Employee update(Employee emp, int empId) {
		return repository.save(emp);
	}

}
