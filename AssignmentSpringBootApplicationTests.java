package com.springBoot;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.springBoot.model.Employee;
import com.springBoot.repository.EmployeeRepository;
import com.springBoot.service.EmployeeService;


@SpringBootTest
public class AssignmentSpringBootApplicationTests {

	@Mock
    EmployeeRepository repository;

    @InjectMocks
    EmployeeService service;

	@Test
	public void getEmployeeTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Employee(100,"Alice","John",28), new Employee(108, "Abhi","Ram", 35)).collect(Collectors.toList()));
		assertEquals(2, service.getAllEmployees().size());
	}

	@Test
	public void getbyIdTest() {
		
		Employee emp=new Employee(100,"Alice","John",28);
		int empId=emp.getEmpId();
		when(repository.findById(empId)).thenReturn(Optional.of(emp));
		assertEquals(empId, service.getById(empId).getEmpId());
	}

	@Test
	public void saveEmployeeTest() {
		Employee emp = new Employee(106, "Preethi","Singh",30);
		service.saveOrUpdate(emp);
		verify(repository, times(1)).save(emp);
	}

	@Test
	public void deleteEmployeeTest() {
		int empId=106;
		service.deleteById(empId);;
		verify(repository, times(1)).deleteById(empId);
	}

}