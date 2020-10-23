package com.sowjanya.jpaonetomany;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository2 extends CrudRepository<Customers, Long>  {
	 List<Customers> findByLastName(String lastName);

}
