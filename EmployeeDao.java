package com.example.employeerest.Dao;

import com.example.employeerest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
