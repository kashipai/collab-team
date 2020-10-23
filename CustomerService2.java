package com.sowjanya.jpaonetomany;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;



@Service("customerService")
public class CustomerService2 {
	
	@Autowired
	private CustomerRepository2 repository;
	
	@Autowired
	private DepartmentRepository2 repository1;
    
    public void test() {
        
        Customers newCustomer = new Customers();
        newCustomer.setFirstName("sowjanya");
        newCustomer.setLastName("jain");
        repository.save(newCustomer);
        
        Customers newCustomer1 = new Customers();
        newCustomer1.setFirstName("pranamya");
        newCustomer1.setLastName("j");
        repository.save(newCustomer);
        
        Customers newCustomer2 = new Customers();
        newCustomer2.setFirstName("aa");
        newCustomer2.setLastName("bb");
        repository.save(newCustomer);
        
        List<Customers> customerlist = new ArrayList();
        customerlist.add(newCustomer);
        customerlist.add(newCustomer1);
        customerlist.add(newCustomer2);
        
        Department2 department = new Department2();
        department.setName("Development");
        repository1.save(department);
        
        department.setCustomerlist(customerlist);
        
        
        Optional<Customers> result = repository.findById(1L);
        result.ifPresent(customer -> System.out.println(customer));
         
        // Find customers by last name
        List<Customers> customers = repository.findByLastName("jain");
        customers.forEach(customer -> System.out.println(customer));
         
        // List all customers
        Iterable<Customers> iterator = repository.findAll();
        iterator.forEach(customer -> System.out.println(customer));
         
        // Count number of customer
        long count = repository.count();
        System.out.println("Number of customers: " + count);

}
}
