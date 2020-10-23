package com.sowjanya.jpaonetomany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 
@Entity
public class Customers {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String firstName;
	    private String lastName;
	    
	    
	   
	 
	    protected Customers() {
	    }
	    
	    
	    public long getId() {
			return id;
		}

		public void setId(long id) {
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


		@Override
	    public String toString() {
	        return "Customer [firstName=" + firstName + ", lastName=" + lastName + "]";
	    }  
		
			
	 
	    
	}


