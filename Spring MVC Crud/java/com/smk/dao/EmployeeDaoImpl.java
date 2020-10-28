package com.smk.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.smk.dto.*;

@Component()
@Primary
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public EmployeeDaoImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
	}

	public void setJdbctemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveOrUpdate(Employee employee) {
		// TODO Auto-generated method stub
		int res;
		if (employee.getEmployeeid() > 0) 
		{
					String sql = "UPDATE employee SET name=?, email=? WHERE employeeid=?";
					res=jdbcTemplate.update(sql, employee.getName(), employee.getEmail(),employee.getEmployeeid());
					//return res;
		}
		else
		{
			String sql = "INSERT INTO employee (name, email)VALUES (?, ?)";
			res=jdbcTemplate.update(sql, employee.getName(), employee.getEmail());
			//return res;
		}
		
		return res;
	}

	public int delete(int employeeid) {
		String sql = "DELETE FROM employee WHERE employeeid=?";
		int del=jdbcTemplate.update(sql, employeeid);
		return del;
	}

	public Employee get(int employeeid) {
		String sql = "SELECT * FROM employee WHERE employeeid=" + employeeid;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
	 
	        public Employee extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	                Employee employee = new Employee();
	                employee.setEmployeeid(rs.getInt("employeeid"));
	                employee.setName(rs.getString("name"));
	                employee.setEmail(rs.getString("email"));
	                return employee;
	            }
	 
	            return null;
	        }
	 
	    });
	}

	public List<Employee> list() {
		String sql = "SELECT * FROM employee";
	    List<Employee> listContact = jdbcTemplate.query(sql, new RowMapper<Employee>() {
	 
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee emp2 = new Employee();
	 
	            emp2.setEmployeeid(rs.getInt("employeeid"));
	            emp2.setName(rs.getString("name"));
	            emp2.setEmail(rs.getString("email"));
	            
	 
	            return emp2;
	        }
	 
	    });
	 
	    return listContact;
	}

}
