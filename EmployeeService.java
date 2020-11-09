package com.example.employeerest.Service;

import com.example.employeerest.model.Employee;

import java.util.List;

public interface EmployeeService {

   public List<Employee> getallEmployee();

    public void deleteEmployee(long id);

   public Employee addEmployee(Employee employee);

   public Employee updateEmployee(long id, Employee employee);
}
