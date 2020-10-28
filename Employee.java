package com.sowjanya.spring.Model;

public class Employee {
	private String name;
	private String location;
	private int id;
	private int salary;

	public Employee() {
		
	}

	public Employee(String name, String location, int id, int salary) {
		super();
		this.name = name;
		this.location = location;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", id=" + id + ", salary=" + salary + "]";
	}

	
}
