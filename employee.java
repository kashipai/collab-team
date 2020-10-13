package com.helloworld.maven.newproject;

public class employee {
	private int id;
	private String name;
	private String address;
	
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public employee(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
