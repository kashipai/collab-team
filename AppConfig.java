package com.sowjanyajain.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration

public class AppConfig {
	
	@Bean
	public  DataSource getDataBase() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employee");
        dataSource.setUsername("root");
        dataSource.setPassword("minion1112");
        return dataSource;
        
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		 JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 return jdbcTemplate;
	}

}
