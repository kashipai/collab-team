package com.employee.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.emplyoee.bean.Employee;

public class RsExtractor implements ResultSetExtractor<List<Employee>> {

	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Employee> EmpList = new ArrayList<Employee>();
		while(rs.next())
		{
			Employee emp = new Employee();
			emp.setEmpId(rs.getString("empid"));
			emp.setName(rs.getString("name"));
			emp.setLocation(rs.getString("location"));
			emp.setPhone(rs.getInt("phone"));
			EmpList.add(emp);
	
			}
		return EmpList;
	
	}

}
