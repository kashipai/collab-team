package com.sowjanya.jpaspring;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;



@Service("customerService")
public class CustomerService1 {
	
	@Autowired
	private CustomerRepository1 repository;
	
	@Autowired
	private DepartmentRepository1 repository1;
    
    public void test() {

        Department1 department = new Department1();
        department.setName("Development");
        repository1.save(department);
       
        
        Customer1 newCustomer = new Customer1();
        newCustomer.setFirstName("sowjanya");
        newCustomer.setLastName("jain");
        newCustomer.setDepartment1(department);
        repository.save(newCustomer);
        
        
        
        Optional<Customer1> result = repository.findById(1L);
        result.ifPresent(customer -> System.out.println(customer));
         
        // Find customers by last name
        List<Customer1> customers = repository.findByLastName("jain");
        customers.forEach(customer -> System.out.println(customer));
         
        // List all customers
        Iterable<Customer1> iterator = repository.findAll();
        iterator.forEach(customer -> System.out.println(customer));
         
        // Count number of customer
        long count = repository.count();
        System.out.println("Number of customers: " + count);

}
}
