package com.sowjanya.spring.Employee.dao;

import java.util.List;

import com.sowjanya.spring.Model.Employee;

public interface EmployeeDAO {
	public int save(Employee employee);
		
	public int update(Employee employee);
	
	public Employee get(int id);
	
	public int delete(int id);
	
	public List<Employee> list();

}
