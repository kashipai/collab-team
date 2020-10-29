package com.manager.employee.model;

public class Employee {
	private String empid;
	private String name;
	private int phone;
	private String location;
	
	public Employee() {
		
	}

	public Employee(String empid, String name, int phone, String location) {
		super();
		this.empid = empid;
		this.name = name;
		this.phone = phone;
		this.location = location;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
