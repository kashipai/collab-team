package com.sowjanyajain.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class GetDatabase {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertData() {
		String sql="INSERT INTO EMPLOYEE (name,location,ID,salary) VALUES(?,?,?,?)";
        int result=jdbcTemplate.update(sql,"stuart","banglore",1000,20000);
        
        if(result>0) {
        	System.out.println("A new employee has been added");
        }
	}

}
