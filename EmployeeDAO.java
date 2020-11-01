package com.springrest.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.springRest.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, String> {

}
