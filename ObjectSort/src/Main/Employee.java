package Main;

import java.util.Date;

public class Employee {
	
	private String firstName,lastName,employeId;
	private Date joiningDate;
	
	
	
	public Employee(String firstName, String lastName, String employeId, Date joiningDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeId = employeId;
		this.joiningDate = joiningDate;
	}



	@Override
	public String toString() {
		return "\nFirstName = " + firstName + ", LastName = " + lastName + ", EmployeId = " + employeId
				+ ", JoiningDate = " + joiningDate ;
	}



	public String getLastName() {
		return lastName;
	}



	public Date getJoiningDate() {
		return joiningDate;
	}

}
