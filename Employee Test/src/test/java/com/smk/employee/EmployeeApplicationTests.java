package com.smk.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;import java.nio.file.FileSystemLoopException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.smk.employee.dao.EmployeeDao;
import com.smk.employee.entity.Employee;
import com.smk.employee.service.EmployeeService;


@SpringBootTest
class EmployeeApplicationTests {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@MockBean
	private EmployeeDao employeedao;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void getEmployeeTest()
	{
		when(employeedao.findAll()).thenReturn(Stream.of(new Employee(1,"smk","Manglore"),new Employee(2,"Sumanth","Hubli")).collect(Collectors.toList()));
		assertEquals(1, employeeservice.getEmployees().size());
	}
	
	@Test
	public void addEmployeeTest()
	{
		Employee employee=new Employee(10,"Virat","Delhi");
		when(employeedao.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeservice.AddEmployee(employee));
	}
	
	@Test
	public void getEmployeeByidTest()
	{
		int id=108;
		when(employeedao.getOne(id)).thenReturn(new Employee(108,"Rahul","MP"));
		assertNotNull(employeeservice.getEmployee(id));
	}
	
	@Test
	public void DeleteByEmployeeid()
	{
		int id=100;
		Employee employee=new Employee(100,"Raj","UP");
		employeedao.deleteById(100);
		verify(employeedao,times(1)).deleteById(id);
	}

}
