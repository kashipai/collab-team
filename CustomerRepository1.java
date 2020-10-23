package com.sowjanya.jpaspring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository1 extends CrudRepository<Customer1, Long>  {
	 List<Customer1> findByLastName(String lastName);

}
