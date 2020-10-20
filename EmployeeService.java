package com.employee.services;

import com.employee.dao.EmployeeDao;
import com.emplyoee.bean.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

 

@Service("empService")
public class EmployeeService implements EmpService {
    @Autowired
    EmployeeDao empDao;
	public void addPerson(Employee emp) {
		  empDao.addPerson(emp);

	}

	public void deletePerson(String EmpId) {
		 empDao.deletePerson(EmpId);

	}

}
