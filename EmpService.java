package com.employee.services;

import java.util.List;

import com.emplyoee.bean.Employee;

public interface EmpService {
	 public void addPerson(Employee emp);
	 public void deletePerson(String EmpId);
	 public List < Employee > findAll();
	 public void alphabeticalArrange();
}
