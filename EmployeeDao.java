package com.employee.dao;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.employee.mapping.CallbackHandler;
import com.employee.mapping.RsExtractor;
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
	   public List < Employee > findAll() {
		   String sql = "SELECT * FROM emp_details";
	        List < Employee > persons = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Employee.class));
	        return persons;
	    }
		public void alphabeticalArrange()
		{
			String sql = "select * from emp_details order by empId";
			List <Employee> employee = jdbcTemplate.query(sql, new RsExtractor());
			
			for (Employee record : employee)
			{   
				 System.out.print("| id : " + record.getEmpId() );
		         System.out.print("| Name : " + record.getName() );
		         System.out.print("| location : " + record.getLocation());
		         System.out.println("| phone : " + record.getPhone() );
		     }
		}
		public void getEmployeeName(CallbackHandler cbh) {

			jdbcTemplate.query("select name from emp_details order by name", cbh);
			System.out.print(cbh.getEmpName());
			
		}

		


}
