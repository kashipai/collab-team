package com.sowjanya;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository repo;
	
	public List<Employee> listAll(){
		return repo.findAll();
	}
	
	public Employee save(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
       repo.deleteById(id);
	}

}
