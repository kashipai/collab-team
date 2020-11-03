package com.springrest.springRest.test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springrest.springRest.dao.EmployeeDAO;
import com.springrest.springRest.entity.Employee;
import com.springrest.springRest.services.EmployeeService;
@RunWith(SpringRunner.class)
@SpringBootTest
class TestCases {
	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeDAO empDao;


	@Test
	public void getAllEmployeeTest() {
		when(empDao.findAll()).thenReturn(Stream
				.of(new Employee("101", "sachin", 432, "karki"), 
						new Employee("102", "srk", 876, "mysore"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getEmployee().size());
	}
	
	@Test
	public void getEmployeetByIdTest() {
		String empid = "101";
		when(empDao.getOne(empid)).thenReturn(new Employee("101", "vinora", 123, "Painting"));
		assertNotNull(service.getEmpId(empid));

	}

@Test
	public void addEmployeeTest() {
		Employee Emp = new Employee("103", "ram", 654, "bang");
		when(empDao.save(Emp)).thenReturn(Emp);
		assertEquals(Emp, service.addEmpId(Emp));
		
	}

	@Test
	public void deleteTest() {
		String empid = "103";
		service.deleteEmpId(empid);
		verify(empDao, times(1)).deleteById(empid);

	}


}
