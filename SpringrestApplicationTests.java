package com.spring.rest.springrest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rest.springrest.dao.StudentDao;
import com.spring.rest.springrest.entity.Student;
import com.spring.rest.springrest.services.StudentServices;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringrestApplicationTests {

	@Autowired
	private StudentServices service;

	@MockBean
	private StudentDao studentDao;

	@Test
	public void getAllStudentTest() {
		when(studentDao.findAll()).thenReturn(Stream
				.of(new Student(101, "Harsharaj", "Devadiga", "Painting"), new Student(102, "Anush", "Shetty", "Dance"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllStudent().size());
	}

	@Test
	public void getStudentByIdTest() {
		int id = 101;
		when(studentDao.getOne(id)).thenReturn(new Student(101, "Harsharaj", "Devadiga", "Painting"));
		assertNotNull(service.getStudent(id));

	}

	@Test
	public void addStudentTest() {
		Student student = new Student(103, "Prajwal", "Amin", "Cricket");
		when(studentDao.save(student)).thenReturn(student);
		assertEquals(student, service.addStudent(student));
	}

	@Test
	public void deleteTest() {
		int id = 103;
		service.deleteStudent(id);
		verify(studentDao, times(1)).deleteById(id);

	}

}
