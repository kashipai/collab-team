package com.sowjanya.JdbccSpring.entity;


public class Employee {
	private String name;
	private String location;
	private int ID;
	private int salary;
	public Employee() {
		
	}
	
	public Employee(String name, String location, int iD, int salary) {
		super();
		this.name = name;
		this.location = location;
		ID = iD;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", ID=" + ID + ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	

}
