package com.employee.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.configuration.ApplicationConfig;
import com.employee.dao.EmployeeDao;
import com.employee.mapping.CallbackHandler;
import com.emplyoee.bean.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class testingClass {
	@Autowired 
	EmployeeDao emp;
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	CallbackHandler callback = context.getBean(CallbackHandler.class);
	EmployeeDao daoObj = context.getBean(EmployeeDao.class);
	
	@Test
	public void test() {
		emp.deletePerson("oo1");
		emp.deletePerson("oo2");
		emp.addPerson(new Employee("oo1","sac","bang",987));
		emp.addPerson(new Employee("oo2","srk","bang",20123));

	}
	@Test
	public void testHandler() {
		 
		 daoObj.getEmployeeName(callback);
	}
	@Test
	public void testExtractor()
	{
		
		daoObj.alphabeticalArrange();
	}

}
