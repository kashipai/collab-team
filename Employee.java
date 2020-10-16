package Sample1;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	// @Value("VAISHNAVI")
	String name;
	// @Value("RT001")
	String id;
	// @Value("9876543210")
	String contact;

	public void display() {

		System.out.println("Employee Details");
		System.out.println("Name:" + this.name);
		System.out.println("ID:" + this.id);
		System.out.println("Contact:" + this.contact);
	}

	public Employee(String name, String id, String contact) {
		super();
		this.name = name;
		this.id = id;
		this.contact = contact;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	

}
