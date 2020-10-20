package com.smk.jdbcassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("implement")
public class LenovoDaoimpl {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int insert(lenovo l1)
	{
		String sql="insert into lenovo values(?,?)";
		Object args[]= {l1.getModelno(),l1.getName()};
		int res=jdbcTemplate.update(sql,args);
		if(res>0)
		{
			System.out.println("Table Updated");
		}
		return res;
	}

}
