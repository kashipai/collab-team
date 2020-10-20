package com.smk.jdbcassignment;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = { "classpath:app.properties" })
@ComponentScan(basePackages = "com.smk.jdbcassignment")
public class LenovoConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
	    dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	    dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	    dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
		
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/lenovo");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

}
