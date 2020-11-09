package com.example.libraryRest.Model;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library
{
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "author")
	String author;
	
	@Column(name = "cost")
	int cost;

	public int getId() {
		return id;
	}

	public void setId(int isbn) {
		this.id = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String bName) {
		this.name = bName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String bAuthor) {
		this.author = bAuthor;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public Library() {}
	
	public Library(int isbn, String bName, String bAuthor, int cost)
	{
		this.id = isbn;
		this.name = bName;
		this.author = bAuthor;
		this.cost = cost;
	}
	
	public String toString()
	{
		return "ISBN:"+id+"\nTitle:"+name+"\nAuthor:"+author+"\nCost:"+cost;
	}
	
}
