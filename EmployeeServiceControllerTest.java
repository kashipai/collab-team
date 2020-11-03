package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmployeeServiceControllerTest {

	@InjectMocks
	EmployeeServiceController employeeServiceController;
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllEmployee() {
		
		List<Employee> employees = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("anny");
		employees.add(emp1);
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("bob");
		employees.add(emp2);
		
		when( employeeRepository.findAll()).thenReturn(employees);		
		assertEquals(2, employeeServiceController.getAllEmployee().size());
	}
	
	@Test
	void testGetEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("drony");
		
		when( employeeRepository.findById(anyInt())).thenReturn((Optional.of(emp)));		
		assertEquals(1, employeeServiceController.getEmployeeById(1).get().getId());
	}
	
	@Test
	void testAddEmployee() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("emy");
		
		when( employeeRepository.save(emp)).thenReturn(emp);
		assertEquals("Saved", employeeServiceController.addNewUser(1, "emy"));
		
	}

}
