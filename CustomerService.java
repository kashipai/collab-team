package com.sowjanya.jpaonetomany;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;



@Service("customerService")
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private DepartmentRepository repository1;
    
    public void test() {
        
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("sowjanya");
        newCustomer.setLastName("jain");
        repository.save(newCustomer);
        
        Customer newCustomer1 = new Customer();
        newCustomer1.setFirstName("pranamya");
        newCustomer1.setLastName("j");
        repository.save(newCustomer);
        
        Customer newCustomer2 = new Customer();
        newCustomer2.setFirstName("aa");
        newCustomer2.setLastName("bb");
        repository.save(newCustomer);
        
        List<Customer> customerlist = new ArrayList();
        customerlist.add(newCustomer);
        customerlist.add(newCustomer1);
        customerlist.add(newCustomer2);
        
        Department department = new Department();
        department.setName("Development");
        repository1.save(department);
        
        department.setCustomerlist(customerlist);
        
        
        Optional<Customer> result = repository.findById(1L);
        result.ifPresent(customer -> System.out.println(customer));
         
        // Find customers by last name
        List<Customer> customers = repository.findByLastName("jain");
        customers.forEach(customer -> System.out.println(customer));
         
        // List all customers
        Iterable<Customer> iterator = repository.findAll();
        iterator.forEach(customer -> System.out.println(customer));
         
        // Count number of customer
        long count = repository.count();
        System.out.println("Number of customers: " + count);

}
}
