package com.spring.rest.springrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "studentid")
	private int studentid;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "hobby")
	private String hobby;

	public Student() {
		super();
	}

	public Student(int studentid, String firstname, String lastname, String hobby) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.hobby = hobby;
	}

	public int getStudentId() {
		return studentid;
	}

	public void setStudentId(int studentid) {
		this.studentid = studentid;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentid + ", firstName=" + firstname + ", lastName=" + lastname + ", hobby="
				+ hobby + "]";
	}
}
