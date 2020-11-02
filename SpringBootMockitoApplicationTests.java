package com.sowjanya;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.when;




@RunWith(SpringRunner.class)
@SpringBootTest
 public class SpringBootMockitoApplicationTests {
	
	@Autowired
	private EmployeeService service;
	
	@MockBean
	private EmployeeRepository repo;
	
	@Test
	public void listAllEmployeesTest() {
		when(repo.findAll()).thenReturn(Stream.of(new Employee(2,"bb","shimoga"),new Employee(3,"sowjanya","abc"),new Employee(4,"sowjanya","ssss")).collect(Collectors.toList()));
		assertEquals(3,service.listAll().size());
		}
	
    
	@Test
    public void getEmployeeByIdTest() {
    	int id=1;
    	when(repo.findById(id).get()).thenReturn(new Employee(2,"bb","shimoga"));
    	assertEquals(1,service.get(id));
    	
    }
    	
	@Test
	public void saveTest() {
		Employee employee=new Employee(2,"rr","ss");
		when(repo.save(employee)).thenReturn(employee);
		assertEquals(employee,service.save(employee));
	}
	
	@Test
	public void deleteTest() {
		Employee employee=new Employee(3,"cc","ss");
		int id=3;
		service.delete(id);
		verify(repo,times(1)).deleteById(id);
		
	}


}


	
