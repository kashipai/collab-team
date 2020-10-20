package com.sowjanya.JdbccSpring.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.sowjanya.JdbccSpring.entity.Employee;

public class EmployeeDoaImpl implements EmployeeDao {

	
	private JdbcTemplate jdbcTemplate;
	public int insert(Employee employee) {
		String query = "insert into employee(name,location,ID,salary) values (?,?,?,?)";
        int result=this.jdbcTemplate.update(query,employee.getName(),employee.getLocation(),employee.getID(),employee.getSalary());
        return result;
	}

	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public int change(Employee employee) {
		String query = "update employee set name=?, location=?,salary=? where ID=?";
        int result=this.jdbcTemplate.update(query,employee.getName(),employee.getLocation(),employee.getID(),employee.getSalary());
        return result;
		
	}



	public int delete(int employeeID) {
		String query = "delete from employee where ID=?";
        int result=this.jdbcTemplate.update(query,employeeID);
        return result;
	}



	public Employee getEmployee(int employeeID) {
		String query = "select *from employee where ID=?";
		RowMapper<Employee> rowMapper=new RowMapperImpl();
        Employee employee=this.jdbcTemplate.queryForObject(query,rowMapper,employeeID);
        return employee;
	}

	public List<Employee> getAllEmployees() {
		String query="select *from employee"; 
		List<Employee> employees=this.jdbcTemplate.query(query,new RowMapperImpl());
		return employees;
	}
	
	public void getnames() {
		CustomRowCallbackHandler handler = new CustomRowCallbackHandler();
        jdbcTemplate.query("select * from employee", handler);
        System.out.println("Names : " + handler.getEmployeeNames());
	}
	
	 final String SELECT_ALL_QUERY = "SELECT name, location, ID, salary from EMPLOYEE";
	 public List<Employee> findAllEmployees() {
		    return this.jdbcTemplate.query(SELECT_ALL_QUERY, 
		    new ResultSetExtractor<List<Employee>>() {
		    	
		      public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		        List<Employee> list = new ArrayList<Employee>();  
		        while(rs.next()){
		          Employee emp = new Employee();
		          emp.setName(rs.getString("name"));
		          emp.setLocation(rs.getString("location"));
		          emp.setID(rs.getInt("ID"));
		          emp.setSalary(rs.getInt("salary"));
		          list.add(emp);
		        }
		        return list;
		      }  
		    });
		  }


}
