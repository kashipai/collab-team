package com.employee.dao;

import com.emplyoee.bean.Employee;

public interface EmpDao {
	  public void addPerson(Employee person);
	  public void deletePerson(String empId);
}
