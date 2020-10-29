package com.manager.employee.dao;

import java.util.List;

import com.manager.employee.model.Employee;


public interface EmployeeDAO {
    public int save(Employee emp);
    
    public int Update(Employee emp);
    
    public int delete(String empid);
     
    public Employee get(String empId);
     
    public List<Employee> list();

}
