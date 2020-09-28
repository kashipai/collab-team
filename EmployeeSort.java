package trainingAssignment;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

class Employee {

	private LocalDate joinDate;
	private String firstName;
	private String lastName;
	
	
    public Employee(LocalDate joinDate, String firstName, String lastName) {
		super();
		this.joinDate = joinDate;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}
	
	public String getEmployeeInfo() {
		return "Employee Name:	"+ firstName+" "+lastName+"\tJoining Date:	"+ joinDate;
	}

}

class LastNameSort implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub

		return o1.getLastName().compareToIgnoreCase(o2.getLastName());
	}
	
}

class JoinDateSort implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		
		return o1.getJoinDate().compareTo(o2.getJoinDate());
	}
	
}

public class EmployeeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> employee = new ArrayList<>();

		employee.add(new Employee((LocalDate.of(2015,03,12)), "Bob", "B"));
		employee.add(new Employee((LocalDate.of(2016,02,2)), "Anny","A"));
		employee.add(new Employee((LocalDate.of(2016,03,20)), "Clob","C"));
		employee.add(new Employee((LocalDate.of(2016,03,20)), "Harry","A"));
		
		
		System.out.println("Names Before Sorting:");
		for(Employee e : employee) {
			System.out.println(e.getEmployeeInfo());
		}
		System.out.println("Names After Last name Sorting:");
		LastNameSort l = new LastNameSort();
		employee.sort(l);
		
		for(Employee e : employee) {
			System.out.println(e.getEmployeeInfo());
		}
		
		
		
		System.out.println("\nJoining Date Before Sorting:");
		for(Employee e : employee) {
			System.out.println(e.getEmployeeInfo());
		}
		
		System.out.println("Joining Date After  Sorting:");
		JoinDateSort j = new JoinDateSort();
		employee.sort(j);
		
		
		for(Employee e : employee) {
			System.out.println(e.getEmployeeInfo());
		}
	}

}
