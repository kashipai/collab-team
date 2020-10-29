package com.manager.employee.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.manager.employee.dao.EmployeeDAO;
import com.manager.employee.dao.EmployeeDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.manager.employee")
public class SpringConfig {
	
	@Bean
	public DataSource getDataSource() {
	DriverManagerDataSource datasource = new DriverManagerDataSource();
	datasource.setDriverClassName("com.mysql.jdbc.Driver");
	datasource.setUrl("jdbc:mysql://localhost:3306/companytraining?autoReconnect=true&useSSL=false");
	datasource.setUsername("root");
	datasource.setPassword("Sachu@1998");
	return datasource;
	}
	
	@Bean
	public ViewResolver getView() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
		
	}
	@Bean
	public EmployeeDAO getEmpDao() {
		return new EmployeeDAOImpl(getDataSource());
	}

}
