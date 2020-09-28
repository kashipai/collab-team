package begin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeCheck {
	int emplId;
	String FirstName;
	String LastName;
	LocalDate DateOfJoin;
	int age;
	double empSalary;

	public EmployeeCheck(int emplId, String FirstName, String LastName, LocalDate DateOfJoin, int age,
			double empSalary) {
		this.emplId = emplId;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DateOfJoin = DateOfJoin;
		this.age = age;
		this.empSalary = empSalary;
	}
}

class LastNameSort implements Comparator<EmployeeCheck> {
	public int compare(EmployeeCheck E1, EmployeeCheck E2) {
		return E1.LastName.compareToIgnoreCase(E2.LastName);
	}
}

class DateOfJoinSort implements Comparator<EmployeeCheck> {
	public int compare(EmployeeCheck E1, EmployeeCheck E2) {
		return E1.DateOfJoin.compareTo(E2.DateOfJoin);
	}
}

public class Employee {
	public static void main(String[] args) {
		List<EmployeeCheck> Emp = new ArrayList<>();
		Emp.add(new EmployeeCheck(180, "Harsharaj", "D", LocalDate.of(2020, 9, 7), 23, 35000));
		Emp.add(new EmployeeCheck(184, "Anush", "Shetty", LocalDate.of(2014, 8, 6), 22, 45000));
		Emp.add(new EmployeeCheck(249, "Prajwal", "Amin", LocalDate.of(2008, 2, 9), 21, 35000));
		Emp.add(new EmployeeCheck(681, "Pranav", "Shet", LocalDate.of(2014, 3, 10), 21, 40000));

		System.out.println("\nSorting by Last Name\n");

		Collections.sort(Emp, new LastNameSort());
		System.out.println("Id \t Full Name \t\t Date of joining \tAge \t\t Salary");
		for (EmployeeCheck emp : Emp) {
			System.out.println(emp.emplId + " \t " + emp.FirstName + " " + emp.LastName + " \t\t" + emp.DateOfJoin
					+ "\t\t" + emp.age + " \t\t" + emp.empSalary);
		}

		System.out.println("\nSorting by Date of Joining\n");

		Collections.sort(Emp, new DateOfJoinSort());
		System.out.println("Id \t Full Name \t\t Date of joining \tAge \t\t Salary");
		for (EmployeeCheck emp : Emp) {
			System.out.println(emp.emplId + " \t " + emp.FirstName + " " + emp.LastName + " \t\t " + emp.DateOfJoin
					+ " \t\t" + emp.age + " \t\t" + emp.empSalary);
		}
	}
}
