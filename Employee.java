package com.springrest.springRest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Employee")
public class Employee {
	private String id;
	private String name;
	private int phone;
	private String location;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", location=" + location + "]";
	}
	

	@Id
	@Column(name = "empid")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.location = location;
	}




}
