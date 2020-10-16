package assignment15_10;

public class Person {

	private final String firstName;
	private final String lastName;
	private final int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String toString() {
		return ("Name: " + firstName + " " + lastName + "\nAge: " + age);
	}
}