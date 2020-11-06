package com.example.springSecurity.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.Set;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "username")
	private String username;
	
	private String password;
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Users() {}
	
	public Users(String uName,String pass,String role)
	{
		this.username = uName;
		this.password = pass;
		this.role = role;
	}
	

}
