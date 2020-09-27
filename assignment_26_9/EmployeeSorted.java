package assignment_26_9;

import java.util.Date;
import java.util.*;
import java.text.SimpleDateFormat;

class Employee {
	int employeeID;
	int age;
	String employeeFirstName;
	String employeeLastName;
	Date dateOfJoining;

	Employee(int empID, int age, String firstName, String lastName, Date doj) {
		this.employeeID = empID;
		this.age = age;
		this.employeeFirstName = firstName;
		this.employeeLastName = lastName;
		this.dateOfJoining = doj;

	}
}

class LastNameComparator implements Comparator<Employee> {
	public int compare(Employee emp1, Employee emp2) {
		return emp1.employeeLastName.compareToIgnoreCase(emp2.employeeLastName);
	}
}

class DOJComparator implements Comparator<Employee> {
	public int compare(Employee emp1, Employee emp2) {
			return (emp1.dateOfJoining.compareTo(emp2.dateOfJoining));
	}
}

public class EmployeeSorted {
	public static void main(String args[]) throws Exception {

		ArrayList<Employee> list = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of employees:");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.println("Enter Employee" + i + " ID:");
			int empId = sc.nextInt();
			System.out.println("Enter Employee" + i + " Age:");
			int age = sc.nextInt();
			System.out.println("Enter Employee" + i + " First Name:");
			String firstName = sc.next();
			System.out.println("Enter Employee" + i + " Last Name:");
			String lastName = sc.next();
			System.out.println("Enter Employee" + i + " Date of joining(dd/MM/yyyy):");
			String dateOfJoining = sc.next();
			SimpleDateFormat doj = new SimpleDateFormat("dd/MM/yyyy");
			Date join = doj.parse(dateOfJoining);

			list.add(new Employee(empId, age, firstName, lastName, join));
		}
		System.out.println("\nEmployee Details");
		System.out.println("Id \t Full Name \t\t Age \t Date of joining");
		for (Employee emp : list) {
			System.out.println(emp.employeeID + " \t " + emp.employeeFirstName + " " + emp.employeeLastName + " \t\t "
					+ emp.age + " \t " + emp.dateOfJoining);
		}

		System.out.println("\nSorting by Last Name\n");

		Collections.sort(list, new LastNameComparator());
		System.out.println("Id \t Full Name \t\t Age \t Date of joining");
		for (Employee emp : list) {
			System.out.println(emp.employeeID + " \t " + emp.employeeFirstName + " " + emp.employeeLastName + " \t\t "
					+ emp.age + " \t " + emp.dateOfJoining);
		}

		System.out.println("\nSorting by Date of Joining\n");

		Collections.sort(list, new DOJComparator());
		System.out.println("Id \t Full Name \t\t Age \t Date of joining");
		for (Employee emp : list) {
			System.out.println(emp.employeeID + " \t " + emp.employeeFirstName + " " + emp.employeeLastName + " \t\t "
					+ emp.age + " \t " + emp.dateOfJoining);
		}
		sc.close();
	}
}
