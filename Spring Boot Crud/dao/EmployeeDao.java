package com.smk.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smk.employee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>
{

}
