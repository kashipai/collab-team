//package com.smk.dao;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.smk.config.EmployeeConfig;
//import com.smk.dto.Employee;
//
//public class EmployeeDaoTest {
//
//	@Test
//	public void testSaveOrUpdate() {
//		//fail("Not yet implemented");
//		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
//		EmployeeDaoImpl empobj=(EmployeeDaoImpl) context.getBean("emp");
//		int res=empobj.saveOrUpdate(new Employee("sumantha","smk@gmail.com"));
//		assertTrue(res>0);
//	}
//
//	@Test
//	public void testDelete() {
//		//fail("Not yet implemented");
//		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
//		EmployeeDaoImpl empobj=(EmployeeDaoImpl) context.getBean("emp");
//		int del=empobj.delete(4);
//		assertTrue(del>0);
//	}
//
//	@Test
//	public void testGet() {
//		//fail("Not yet implemented");
//		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
//		EmployeeDaoImpl empobj=(EmployeeDaoImpl) context.getBean("emp");
//		Employee emp=empobj.get(5);
//		if(emp!=null)
//		{
//			System.out.println(emp);
//		}
//		assertNotNull(emp);
//	}
//
//	@Test
//	public void testList() {
//		//fail("Not yet implemented");
//		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
//		EmployeeDaoImpl empobj=(EmployeeDaoImpl) context.getBean("emp");
//		List<Employee>employee=empobj.list();
//		for(Employee em:employee)
//		{
//			System.out.println(em);
//		}
//		if(!(employee.isEmpty()));
//		
//	}
//
//}
