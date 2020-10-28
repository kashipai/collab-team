package com.sowjanya.spring.Employee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.sowjanya.spring.Model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		
	}

	public int save(Employee e) {
		String sql="insert into Employee(name,location,id,salary) values(?,?,?,?)";
		return jdbcTemplate.update(sql,e.getName(),e.getLocation(),e.getId(),e.getSalary());
	
	}

	public int update(Employee e) {
		String sql="update Employee name=?,location=? where id=?,salary=?";
		return jdbcTemplate.update(sql,e.getName(),e.getLocation(),e.getId(),e.getSalary());
	}

	public Employee get(int id) {
		String sql="select *from employee where id="+id;
		ResultSetExtractor<Employee> extractor=new ResultSetExtractor<Employee>() {

			public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name=rs.getString("name");
					String location=rs.getString("location");
					int id=rs.getInt("id");
					int salary=rs.getInt("salary");
					return new Employee(name,location,id,salary);
					
				}
				return null;
				
			}
		};
		return jdbcTemplate.query(sql,extractor);
	}
		
	
	public int delete(int id) {
		String sql="delete from employee where id="+id;
		return jdbcTemplate.update(sql);
	}

	public List<Employee> list() {
		String sql="select *from employee";
		RowMapper<Employee> rowmapper=new RowMapper<Employee>(){

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				String name=rs.getString("name");
				String location=rs.getString("location");
				int id=rs.getInt("id");
				int salary=rs.getInt("salary");
				return new Employee(name,location,id,salary);
				
			}
			
		};
		return jdbcTemplate.query(sql,rowmapper);
	}

}
