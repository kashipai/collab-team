package com.sowjanya.spring.Employee.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sowjanya.spring.Model.Employee;

class EmployeeDAOTest {
	
	private DriverManagerDataSource dataSource;
	private EmployeeDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employee?autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("minion1112");
      
		dao=new EmployeeDAOImpl(dataSource);
		
	}

	@Test
	void testSave() {
		
		Employee employee=new Employee("ff","banglore",156,20000);
		int result=dao.save(employee);
		assertTrue(result>0);
		
	}

	@Test
	void testUpdate() {
		Employee employee=new Employee("ff","banglore",156,2000);
		int result=dao.update(employee);
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		int id=100;
		Employee employee=dao.get(id);
		assertNotNull(employee);
	}

	@Test
	void testDelete() {
		int id=156;
		int result=dao.delete(id);
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Employee> listemployee=dao.list();
		for(Employee emp:listemployee) {
			System.out.println(emp);
			
		}
		assertTrue(!listemployee.isEmpty());
	}

}
