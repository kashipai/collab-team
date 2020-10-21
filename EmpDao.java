package com.employee.dao;

import java.util.List;

import com.employee.mapping.CallbackHandler;
import com.emplyoee.bean.Employee;

public interface EmpDao {
	  public void addPerson(Employee person);
	  public void deletePerson(String empId);
	  public List < Employee > findAll();
      void alphabeticalArrange();
      void getEmployeeName(CallbackHandler cbh);
	 
}
