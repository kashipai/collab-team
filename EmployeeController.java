package com.example.employeerest.controller;

import com.example.employeerest.Service.EmployeeService;
import com.example.employeerest.model.Employee;
import com.example.employeerest.Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    EmployeeDao employeeDao;


    @GetMapping("/allEmployees")
    public List<Employee>getall(){
        return employeeService.getallEmployee();

    }
    @DeleteMapping("/deleteEmployee/{id}")
    public List<Employee> delete(@PathVariable("id") long id){
       return employeeService.deleteEmployee(id);
       }

    @PostMapping("/addEmployee")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
}
