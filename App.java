package com.employee.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.employee.configuration.ApplicationConfig;
import com.employee.services.EmployeeService;
import com.emplyoee.bean.Employee;



public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		EmployeeService obj = context.getBean("empService", EmployeeService.class);
	   
	 
	        Employee yashwant = new Employee("1oo1","sachin","hnnr",123456);
	        Employee mahesh = new  Employee("2oo2", "Mahesh", "Patil", 25);
	        Employee vishal = new  Employee("3oo3", "Vishal", "Naik", 40);
	 
	        obj.addPerson(yashwant);
	        obj.addPerson(mahesh);
	        obj.addPerson(vishal);
	 
	        System.out.println("Delete person Id = 300");
	        String deleteMe = "1oo1";
	        obj.deletePerson(deleteMe);
		
	        
	        System.out.println("Find All");
	        List < Employee > persons = obj.findAll();
	        for (Employee person: persons) {
	            System.out.println(person);
	        }
	        System.out.println("order wise.......");
	        obj.alphabeticalArrange();
	        

	
	        
	        context.close();
	    

	}

}
