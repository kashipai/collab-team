package com.example.employeerest.Service;

import com.example.employeerest.Dao.EmployeeDao;
import com.example.employeerest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public List<Employee> getallEmployee() {
             return employeeDao.findAll();
    }

    @Override
    public void deleteEmployee(long id) {
        employeeDao.deleteById(id);

    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(new Employee(employee.getId(), employee.getName(), employee.getAge(),employee.getRoll()));


    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        Optional<Employee> employeeData = employeeDao.findById(id);
            Employee _employee = employeeData.get();
            _employee.setId(employee.getId());
            _employee.setName(employee.getName());
            _employee.setAge(employee.getAge());
            _employee.setRoll(employee.getRoll());
            return employeeDao.save(_employee);
    }
}
