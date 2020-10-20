package com.sowjanya.JdbccSpring;

import org.springframework.context.ApplicationContext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sowjanya.JdbccSpring.Dao.CustomRowCallbackHandler;
import com.sowjanya.JdbccSpring.Dao.EmployeeDao;
import com.sowjanya.JdbccSpring.entity.Employee;
import java.util.List;

public class main
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context=new AnnotationConfigApplicationContext(jdbcconfig.class);
        EmployeeDao employeedao=context.getBean(EmployeeDao.class);
        
        Employee emp=new Employee();
        emp.setName("stuart");
        emp.setLocation("bnglr");
        emp.setID(100);
        emp.setSalary(50000);
        
        int r=employeedao.insert(emp);
        System.out.println("number of students inserted"+" "+r);
        
        Employee emp1=new Employee();
        emp1.setName("stuart");
        emp1.setLocation("bnglr");
        emp1.setID(100);
        emp1.setSalary(50000);
        
        int s=employeedao.change(emp1);
        System.out.println("number of students chamged"+" "+r);
        
        
        int t=employeedao.delete(100);
        System.out.println("deleted"+" "+t);
        
        
        Employee employee=employeedao.getEmployee(101);
        System.out.println(employee);
        
        
        
       List<Employee> employees=employeedao.getAllEmployees();
        for(Employee e:employees)
        {
        	System.out.println(e);
        }
        
        employeedao.getnames();
        
        List<Employee> employee1=employeedao.findAllEmployees();{
        	for(Employee e:employee1)
            {
            	System.out.println(e);
            }
        	
        }
        
    }
}
