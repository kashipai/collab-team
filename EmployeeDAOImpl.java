package com.manager.employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.manager.employee.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	 private JdbcTemplate jdbcTemplate;
	 
	 public EmployeeDAOImpl(DataSource datasource) {
		 this.jdbcTemplate = new JdbcTemplate(datasource);
	 }

	public int save(Employee emp) {
        String sql = "INSERT INTO emp_details (empid, name, phone, location)"
                + " VALUES (?, ?, ?, ?)";
    return jdbcTemplate.update(sql,emp.getEmpid(), emp.getName(), emp.getPhone(),
            emp.getLocation());

	}
	public int Update(Employee emp) {
		String sql = "UPDATE emp_details SET name=?, phone=?, location=? WHERE empid=?";
    return jdbcTemplate.update(sql, emp.getName(), emp.getPhone(),
            emp.getLocation(), emp.getEmpid());
		
		
	}

	public int delete(String empid) {
	    String sql = "DELETE FROM emp_details WHERE empid=?";
	    return jdbcTemplate.update(sql, empid);

	}

	public Employee get(String empId) {
		  String sql = "SELECT * FROM emp_details WHERE empid=" + "empId";
		  
		ResultSetExtractor<Employee> extractor = new ResultSetExtractor<Employee>() {
			
			
	    public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			if(rs.next()) {
				String empid = rs.getString("empid");
				String name = rs.getString("name");
				int phone = rs.getInt("phone");
				String location = rs.getString("location");
				
				return new Employee(empid,name,phone,location);
				
			}
			return null;
		}
	      
			  
			  
		  };
		return jdbcTemplate.query(sql,extractor);
	}

	public List<Employee> list() {
		 String sql = "SELECT * FROM emp_details";
		 
		 RowMapper<Employee> rowmap = new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				String empid = rs.getString("empid");
				String name = rs.getString("name");
				int phone = rs.getInt("phone");
				String location = rs.getString("location");
				
				return new Employee(empid,name,phone,location);
			}
			 
		 };
		 return jdbcTemplate.query(sql, rowmap);
		
	}

}
