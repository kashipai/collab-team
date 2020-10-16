package assignment15_10;

public class Student {
	private Person person;
	private int rollNo;
	private String stream;

	public Student(Person person, int rollNo, String stream) {
		super();
		this.rollNo = rollNo;
		this.person = person;
		this.stream = stream;
	}

	void display() {
		System.out.println(person.toString());
		System.out.println("Roll number: " + rollNo);
		System.out.println("Stream opted: " + stream);

	}
}
