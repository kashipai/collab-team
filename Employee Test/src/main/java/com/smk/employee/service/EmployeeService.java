package com.smk.employee.service;
import java.util.List;

import com.smk.employee.entity.*;

public interface EmployeeService {
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int Employeeid);

	public Employee AddEmployee(Employee employee);

	public void deleteById(int empId);




}
