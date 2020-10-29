package com.example.libraryRest.Model;

import javax.persistence.*;

@Entity
@Table(name = "library")
public class Library
{
	@Id
	@Column(name = "id")
	int id;
	
	String bName;
	String bAuthor;
	int cost;

	public int getId() {
		return id;
	}

	public void setId(int isbn) {
		this.id = isbn;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
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
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.cost = cost;
	}
	
}
