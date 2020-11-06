package com.example.springSecurity.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	
	@Id
	@Column(name = "id")
	private int id;
	
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person() {}
	
	public Person(int id, String name, int age)
	{
		this.id= id;
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return "id :"+id+"name :"+name+"age :"+age+"\n";
	}
}
