package demo_spring_mvc.student.model;

public class Student {
	int rollNo;
	String firstName;
	String lastName;
	String email;

	public Student(int rollNo, String firstName, String lastName, String email) {
		super();
		this.rollNo = rollNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Student() {
		
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRollNo() {
		return rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Student [RollNo=" + rollNo + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email=" + email
				+ "]";
	}

}
