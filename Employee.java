package employee.spring.API;

public class Employee {

	private int EmployeeID;
	private String FirstName;
	private String LastName;
	private int Salary;
	private int Age;

	public Employee() {
		
	}
	
	public Employee(int employeeID, String firstName, String lastName, int salary, int age) {
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		Salary = salary;
		Age = age;
	}

	public int getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Salary=" + Salary + ", Age=" + Age + "]";
	}

}
