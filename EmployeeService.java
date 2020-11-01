package com.springrest.springRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springRest.entity.Employee;
@Service
public interface EmployeeService {
	public List<Employee> getEmployee();
	public Employee getEmpId(String empid);
	public void addEmpId(Employee emp);
	public void deleteEmpId(String empid);

}
