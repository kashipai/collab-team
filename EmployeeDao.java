package com.sowjanya.JdbccSpring.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.sowjanya.JdbccSpring.entity.Employee;


public interface EmployeeDao {
	public int insert(Employee employee);
	
	public int change(Employee employee);
	
	public int delete(int employeeID);

	public Employee getEmployee(int employeeID);
	
	public JdbcTemplate getJdbcTemplate();
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);
	
    public List<Employee> getAllEmployees();
    
    public void getnames();
    public List<Employee> findAllEmployees();

	

}
