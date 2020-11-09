package com.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springBoot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}