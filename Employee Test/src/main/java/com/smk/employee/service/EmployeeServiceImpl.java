package com.smk.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smk.employee.dao.EmployeeDao;
import com.smk.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;
	

	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeedao.findAll();
	}

	@Override
	public Employee getEmployee(int Employeeid) {
		return employeedao.getOne(Employeeid);
	}

	public Employee AddEmployee(Employee employee) {
		employeedao.save(employee);
		return employee;
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		employeedao.deleteById(empId);
		
	}

	
	
	
	

}
