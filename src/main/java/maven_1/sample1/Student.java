package maven_1.sample1;

public class Student {
	private String name;
	String id;
	String contact;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void displayInfo() {
		System.out.println("name: " + getName());
		System.out.println("ID-" + getId());
		System.out.println("Contact:"+getContact());
	}

	public Student(String name, String id, String contact) {
		super();
		this.name = name;
		this.id = id;
		this.contact = contact;
	}
	
}
