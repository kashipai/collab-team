package Sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Department {
	@Autowired
	Employee employee;
	String name;
	String id;

	public void display() {
		employee.display();
		System.out.println("\nDepartment Details:");
		System.out.println("Name:" + this.name);
		System.out.println("ID:"+this.id);
	}

	public Department(Employee employee, String name, String id) {
		this.employee = employee;
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	

}
