package assignment15_10;

public class Employee {
	private Person person;
	private int employeeId;
	private String designation;

	public Employee(int employeeId, Person person, String designation) {
		super();
		this.employeeId = employeeId;
		this.person = person;
		this.designation = designation;
	}

	void display() {
		System.out.println("Employee Id: " + employeeId);
		System.out.println(person.toString());
		System.out.println("Deignation: " + designation);

	}
}
