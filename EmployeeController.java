package com.sowjanya;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public Response  list(){
		List<Employee> employee= service.listAll();
		return new Response("record counts"+employee.size(),Boolean.TRUE);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
		try {
		Employee employee = service.get(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	    }catch(NoSuchElementException e) {
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }

    }
	
	@PostMapping("/employees")
	public Response add(@RequestBody Employee employee) {
		service.save(employee);
		return new Response(employee.toString()+"inserted",Boolean.TRUE);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable Integer id) {
	    try {
	        Employee existProduct = service.get(id);
	        service.save(existProduct);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
}
