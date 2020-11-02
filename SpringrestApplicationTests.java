package com.spring.rest.springrest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rest.springrest.entity.Student;
import com.spring.rest.springrest.services.StudentServices;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringrestApplicationTests {

	@Autowired
	private StudentServices studentservice;

	@Test
	void testadd() {
		Student student = new Student(101, "Harsharaj", "Devadiga", "Painting");
		Student result = studentservice.addStudent(student);
		assertNotNull(result);
	}

	@Test
	void testdeleteStudent() {
		int studentId = 101;
		int result = studentservice.deleteStudent(studentId);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Student student = new Student(101, "Harsharaj", "Devadiga", "Painting");
		Student result = studentservice.updateStudent(student);
		assertNotNull(result);
	}

	@Test
	void testgetAllStudent() {
		List<Student> result = studentservice.getAllStudent();
		assertNotNull(result);
	}

	@Test
	void testgetStudent() {
		int studentId = 101;
		Student result = studentservice.getStudent(studentId);
		assertNotNull(result);
	}
}
