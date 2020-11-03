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

	public void saveOrUpdate(Employee emp) {
		repository.save(emp);

	}

	public Employee getById(int empId) {
		return repository.findById(empId).get();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public void update(Employee emp, int empId) {
		repository.save(emp);
	}

}
