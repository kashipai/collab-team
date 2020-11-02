package com.spring.rest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.springrest.dao.StudentDao;
import com.spring.rest.springrest.entity.Student;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudent() {
		
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(int studentId) {
		
		return studentDao.getOne(studentId);
	}

	@Override
	public Student addStudent(Student student) {
	 studentDao.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		 studentDao.save(student);
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		 studentDao.deleteById(studentId);
	}

}
