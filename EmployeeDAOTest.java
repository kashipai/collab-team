package com.manager.employee.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.manager.employee.model.Employee;

public class EmployeeDAOTest {
	private DriverManagerDataSource datasource;
	private EmployeeDAOImpl dao;
	
	@Before
	public void setUP() {
		datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/companytraining?autoReconnect=true&useSSL=false");
		datasource.setUsername("root");
		datasource.setPassword("Sachu@1998");
		
		dao = new EmployeeDAOImpl(datasource);
		
	}
	
	@Test
    public void testSave() {

		Employee e = new Employee("rks","sachin", 7860, "uio");
	    int res = dao.save(e);
	    assertTrue(res>0);
		
	}
	@Test
    public void testupdate() {

		Employee e = new Employee("rks","sin", 786009, "uio");
	    int res = dao.Update(e);
	   
		
	}
	
	@Test
	public void testGet() {
	String empid = "rks";
	Employee e = dao.get(empid);
	assertNotNull(e);
	}
	@Test
	public void testDelete() {
		String empid = "rks";
		int e = dao.delete(empid);
		assertNotNull(e);
	}


	/*@Test
	public void testList() {
		fail("Not yet implemented");
	}*/

}
