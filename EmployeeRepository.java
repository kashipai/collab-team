package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

      Optional<Employee> findById(int id);
}
