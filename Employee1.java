package java_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee1 {
	    private int id = -1;
	    private String firstName = null;
	    private String lastName = null;
	    private int age = -1;
	 
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public Employee1(int id, String fName, String lName, int age) {
	        this.id = id;
	        this.firstName = fName;
	        this.lastName = lName;
	        this.age = age;
	    }
	 
	    public int compareTo(Employee1 o) {
	        return this.id - o.id;
	    }
	    public String toString() {
	        return "Employee : " + id + " - " + firstName + " - " + lastName
	        + " - " + age + "\n";
	    }
	    
	    
	    public static void main(String[] args) {
	        Employee1 e1 = new Employee1(1, "A", "h", 34);
	        Employee1 e2 = new Employee1(2, "B", "e", 30);
	        Employee1 e3 = new Employee1(3, "C", "g", 31);
	        Employee1 e4 = new Employee1(4, "D", "f", 25);
	 
	        List<Employee1> employees = new ArrayList<Employee1>();
	        employees.add(e2);
	        employees.add(e3);
	        employees.add(e1);
	        employees.add(e4);
	 
	        // UnSorted List
	        System.out.println(employees+"\n");
	 
	        Collections.sort(employees,new LastNameSorter());
	 
	        System.out.println(employees);
	    }
}
