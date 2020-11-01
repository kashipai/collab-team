package com.springrest.springRest.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springRest.dao.EmployeeDAO;
import com.springrest.springRest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	private EmployeeDAO empdao;
	


	@Override
	public List<Employee> getEmployee() {
		return empdao.findAll();
	}



	@Override
	public Employee getEmpId(String empid) {
		

		return empdao.findById(empid).get();
	}

	@Override
	public void addEmpId(Employee emp) {
		empdao.save(emp);
	}

	@Override
	public void deleteEmpId(String empid) {
		empdao.deleteById(empid);
	}

}
