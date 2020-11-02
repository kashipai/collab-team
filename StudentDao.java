package com.spring.rest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.springrest.entity.Student;

public interface StudentDao extends JpaRepository<Student,Integer> {
	

}
