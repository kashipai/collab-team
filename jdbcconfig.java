package com.sowjanya.JdbccSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sowjanya.JdbccSpring.Dao.EmployeeDao;
import com.sowjanya.JdbccSpring.Dao.EmployeeDoaImpl;
//import com.sowjanya.JdbccSpring.Dao.EmployeeDoaImpl;


@Configuration
public class jdbcconfig {
	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/employee");
		ds.setUsername("root");
		ds.setPassword("minion1112");
		return ds;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
		
	}
	
	@Bean
	public EmployeeDao getEmployee() {
		 EmployeeDao empDao=new EmployeeDoaImpl();
		 empDao.setJdbcTemplate(getTemplate());
		 return empDao;
		 
		 
		 
	}

	//}

}
