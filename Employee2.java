package java_ex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Employee2 {
	    private int id = -1;
	    private String firstName = null;
	    private String lastName = null;
	    private int age = -1;
	    private LocalDate date;
	 
	    public LocalDate getDate() {
			return date;
		}

		public void setDate(LocalDate date) {
			this.date = date;
		}

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

		public Employee2(int id, String fName, String lName, int age, LocalDate date) {
	        this.id = id;
	        this.firstName = fName;
	        this.lastName = lName;
	        this.age = age;
	        this.date = date;
	    }
	 
	    public int compareTo(Employee2 o) {
	        return this.id - o.id;
	    }
	    public String toString() {
	        return "Employee : " + id + " - " + firstName + " - " + lastName
	        + " - " + age + " - " + date +"\n";
	    }
	    
	    
	    public static void main(String[] args) {
	    	LocalDate d1 = LocalDate.of(2000, 11, 21);
	    	LocalDate d2 = LocalDate.of(2005, 12, 13); 
	    	LocalDate d3 = LocalDate.of(2010, 1, 3);
	    	LocalDate d4 = LocalDate.of(2012, 10, 30); 
	    	
	    	
	        Employee2 e1 = new Employee2(1, "A", "h", 34, d1);
	        Employee2 e2 = new Employee2(2, "B", "e", 30, d2);
	        Employee2 e3 = new Employee2(3, "C", "g", 31, d3);
	        Employee2 e4 = new Employee2(4, "D", "f", 25, d4);
	 
	        List<Employee2> employees = new ArrayList<Employee2>();
	        employees.add(e2);
	        employees.add(e3);
	        employees.add(e1);
	        employees.add(e4);
	 
	        // UnSorted List
	        System.out.println(employees+"\n");
	 
	        Collections.sort(employees,new joinDateSorter());
	 
	        System.out.println(employees);
	    }
}
