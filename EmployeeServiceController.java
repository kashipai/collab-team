package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeServiceController {

	@Autowired
	EmployeeRepository empRepo;
	
    @PostMapping(path="/add") 
    public @ResponseBody String addNewUser (@RequestParam int id, @RequestParam String name) {
	    Employee emp = new Employee();
    	emp.setId(id);
	    emp.setName(name);
	    empRepo.save(emp);
	    return "Saved";
	  }

	@GetMapping(path = "/employee")
	public List<Employee> getAllEmployee() {
		List<Employee> employees = (List<Employee>) empRepo.findAll();
		return employees;		  
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return empRepo.findById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
		try {
			empRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
}
