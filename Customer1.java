package com.sowjanya.jpaspring;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 
@Entity
public class Customer1{
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    private String firstName;
	    private String lastName;
	    
	    @OneToOne
	    private Department1 department;
	 
	    protected Customer1() {
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
		
		public Department1 getDepartment1() {
		      return department;
		   }

        public void setDepartment1(Department1 department) {
		      this.department = department;
		   }	
	 
	    
	}


