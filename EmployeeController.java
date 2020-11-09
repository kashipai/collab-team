package com.example.employeerest.controller;

import com.example.employeerest.Service.EmployeeService;
import com.example.employeerest.model.Employee;
import com.example.employeerest.Dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
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
    public void delete(@PathVariable("id") long id){
       employeeService.deleteEmployee(id);
       }

    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
         employeeService.addEmployee(employee);
    }
    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }
}
