package com.spring.rest.springrest.controller;

import java.util.List;

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

import com.spring.rest.springrest.entity.Student;
import com.spring.rest.springrest.services.StudentServices;

@RestController
public class MyController {

	@Autowired
	private StudentServices studentservice;

	@GetMapping("/Students")
	public List<Student> getAllStudent() {
		return studentservice.getAllStudent();
	}

	@GetMapping("/Students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return studentservice.getStudent(studentId);
	}
	
	@PostMapping("/Students")
	public Student addStudent(@RequestBody Student student) {
		return studentservice.addStudent(student);
	}
	
	@PutMapping("/Students")
	public Student updateStudent(@RequestBody Student student) {
		return studentservice.updateStudent(student);
	}
	
	@DeleteMapping("/Students/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int studentId) {
		try {
			studentservice.deleteStudent(studentId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 
	}
	
	
}
