package com.spring.rest.springrest.services;

import java.util.List;

import com.spring.rest.springrest.entity.Student;

public interface StudentServices {

	public List<Student> getAllStudent();

	public Student getStudent(int studentId);

	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public int deleteStudent(int studentId);
}
