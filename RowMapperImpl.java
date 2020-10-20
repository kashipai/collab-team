package com.sowjanya.JdbccSpring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sowjanya.JdbccSpring.entity.Employee;

public class RowMapperImpl implements RowMapper<Employee>{
	
	public Employee mapRow(ResultSet rs,int rowNum) throws SQLException {
	Employee employee=new Employee();
	employee.setName(rs.getString(1));
	employee.setLocation(rs.getString(2));
	employee.setID(rs.getInt(3));
	employee.setSalary(rs.getInt(4));
	return employee;
	
}
	
	

	
	

}
