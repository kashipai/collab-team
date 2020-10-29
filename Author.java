package jpa_oneToOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Author")
public class Author {

	@Id
	@Column(name = "authorId")
    @GeneratedValue
    private int authorId;
    private String firstName;
    private String lastName;
    
	public Author() {
	}

	public Author(int id, String firstName, String lastName) {
		super();
		this.authorId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return authorId;
	}

	public void setId(int id) {
		this.authorId = id;
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

	@Override
	public String toString() {
		return "Author [id=" + authorId + ", Name: " + firstName + " " + lastName + "]";
	}
	
	
    
 
}
