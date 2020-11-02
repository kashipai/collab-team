package com.smk.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	private int Employeeid;
	private String Name,Location;
	
	public Employee() {
		super();
	}

	public Employee(int employeeid, String name, String location) {
		super();
		Employeeid = employeeid;
		Name = name;
		Location = location;
	}

	public int getEmployeeid() {
		return Employeeid;
	}

	public void setEmployeeid(int employeeid) {
		Employeeid = employeeid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Employee [Employeeid=" + Employeeid + ", Name=" + Name + ", Location=" + Location + "]";
	}
	
	
	

}
