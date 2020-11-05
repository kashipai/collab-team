package com.spring.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	private String empid;
	private String name;
	private int phone;
	private String location;
	@Override
	public String toString() {
		return "Employee [id=" + empid + ", name=" + name + ", phone=" + phone + ", location=" + location + "]";
	}
	

	@Id
	@Column(name = "empid")
	public String getId() {
		return empid;
	}
	public void setId(String id) {
		this.empid = id;
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
	protected Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String id, String name, int phone, String location) {
		this.empid = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
	}



}
