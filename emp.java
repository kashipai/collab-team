package collectionemployee;

import java.util.ArrayList;
import java.util.Collections;
//package collectionemployee;

import java.sql.Date;
import java.util.Comparator;

import javax.xml.crypto.Data;

class employee {
	int empID; 
    String Fname;
    String Lname;
    Date date;
  
    public employee(int empID, String Fname, String Lname,int Date) 
    { 
        this.empID = empID; 
        this.Fname = Fname; 
        this.Lname = Lname; 
        this.date  = date;
    } 
    
    public int getId() {
    return empID;
    }

    public String getfName() {
    return Fname;
    }

    public String getlName() {
        return Lname;
        }

   

    public Date getdoj() {
    return date;
    }


  
   
    public static Comparator<employee> eCompName = new Comparator<employee>() 
    {
	public int compare(employee e1, employee e2) {
	   String StudentName1 = e1.getlName();
	   String StudentName2 = e2.getlName();

	   return StudentName1.compareTo(StudentName2);

    }};
    public static Comparator<employee> eCompDate = new Comparator<employee>() 
    {
  	  public int compare(employee e1, employee e2) {
  	      if (e1.getdoj() == null || e2.getdoj() == null)
  	        return 0;

  	      return e1.getdoj().compareTo(e2.getdoj());
  	  }
  	};
} 




public class emp {
	 public static void main (String[] args) 
	    { 
	        ArrayList<employee> ar = new ArrayList<employee>(); 
	        ar.add(new employee(1, "aname", "pname",2020-02-12)); 
	        ar.add(new employee(131, "cname", "rname",2020-03-9)); 
	        ar.add(new employee(121, "bname", "qname",2020-02-10)); 
	  
	        System.out.println("Unsorted"); 
	        for (int i=0; i<ar.size(); i++) 
	            System.out.println(ar.get(i)); 
	  
	       // Collections.sort(ar, new SortbyLname()); 
	  
	        Collections.sort(ar, employee.eCompName);

	        System.out.println("Sorted by Last name");
	        System.out.println();
	        System.out.println("----------------------------------------------------------------------------------------------");
	        for (employee s : ar) 
	        {

	        	System.out.println(s.getId()+" "+s.getfName()+" "+s.getlName()+" " +s.getdoj());
	        	System.out.println();
	        }

	        System.out.println("Sorted by Date of joining");
	        System.out.println();
	        
	        System.out.println("----------------------------------------------------------------------------------------------");

	        Collections.sort(ar, employee.eCompDate);

	        for (employee s : ar) 
	        {

	        	System.out.println(s.getId()+" "+s.getfName()+" "+s.getlName()+" " +s.getdoj());
	        	System.out.println();
	        } 
	    } 

}
