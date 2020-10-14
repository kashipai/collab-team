package exercise2;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private int rollNo;  
	private String name;  
	private Address address;
	private String stream;
	    
	public Student(int rollNo, String name, Address address) {  
	    super();  
	    this.rollNo = rollNo;  
	    this.name = name;  
	    this.address = address;  
	}  
	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}
	  
	void display(){ 
		
	    System.out.println("Roll number: "+rollNo+"\nName: "+name);  
	    System.out.println("Stream opted: "+getStream());
	    System.out.println(address.toString());  

	}  
	

}
