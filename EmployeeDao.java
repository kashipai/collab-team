package com.employee.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.emplyoee.bean.Employee;


@Repository
@Qualifier("EmployeeDao")
public class EmployeeDao implements EmpDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void addPerson(Employee person) {
        jdbcTemplate.update("INSERT INTO emp_details (empid, name, phone, location) VALUES (?, ?, ?, ?)",
                person.getEmpId(), person.getName(), person.getPhone(), person.getLocation());
            System.out.println("Person Added!!");

	}
	public void deletePerson(String empId) {
        jdbcTemplate.update("DELETE from emp_details WHERE empid = ? ", empId);
        System.out.println("Person Deleted!!");

	}

}
