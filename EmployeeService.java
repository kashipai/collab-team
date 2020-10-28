package com.example.employeerest.Service;

import com.example.employeerest.model.Employee;

import java.util.List;

public interface EmployeeService {

   public List<Employee> getallEmployee();

    public List<Employee> deleteEmployee(long id);

   public List<Employee> addEmployee(Employee employee);

   public Employee updateEmployee(long id, Employee employee);
}
