package practice;

import java.util.Comparator;
import java.text.DateFormat;
import java.util.*;
import java.text.SimpleDateFormat;

public class Employee 
{
    public String id;
    public String fName;
    public String lName;
    public String city;
    public Date doj;
 
 
    //Parameterized Constructor
    public Employee(String id, String fname, String lname, String city,Date doj)
    {
        this.id = id;
        this.fName = fname;
        this.lName = lname;
        this.city=city;
       this.doj = doj;
        
    }
 
    public String getId() {
    return id;
    }
 
    public String getfName() {
    return fName;
    }
    
    public String getlName() {
        return lName;
        }
 
    public String getCity() {
    return city;
    }
    
    public Date getdoj() {
    return doj;
    }
 
    public static Comparator<Employee> eCompName = new Comparator<Employee>() 
    {
	public int compare(Employee e1, Employee e2) {
	   String StudentName1 = e1.getlName().toUpperCase();
	   String StudentName2 = e2.getlName().toUpperCase();

	   return StudentName1.compareTo(StudentName2);

    }};
    public static Comparator<Employee> eCompDate = new Comparator<Employee>() 
    {
  	  public int compare(Employee e1, Employee e2) {
  	      if (e1.getdoj() == null || e2.getdoj() == null)
  	        return 0;
  	      
  	      return e1.getdoj().compareTo(e2.getdoj());
  	  }
  	};
    
public static void main(String[] args) throws Exception 
    {
     List<Employee> list = new ArrayList<Employee>();
     
     Scanner sc = new Scanner(System.in);
     
     System.out.println("Enter the number of employees");
     int num = sc.nextInt();
     
     for(int i = 1; i <= num; i++)
     {
    	 System.out.println("Enter Employee"+i+" Id:"); 
    	 String eId = sc.next();
    	 System.out.println("Enter Employee"+i+" First Name:"); 
    	 String fname = sc.next();
    	 System.out.println("Enter Employee"+i+" Last Name:"); 
    	 String lname = sc.next();
    	 System.out.println("Enter Employee"+i+" city:"); 
    	 String city = sc.next();
    	 System.out.println("Enter Employee"+i+" Date of joining(yyyy-mm-dd):"); 
    	 String doj1 = sc.next();
    	 SimpleDateFormat doj = new SimpleDateFormat("yyyy-mm-dd");
    	 Date dt = doj.parse(doj1);
    	 
    	 list.add(new Employee(eId,fname,lname,city,dt));
     }
     
     System.out.println("Original list");
     System.out.println();
     System.out.println("Id|| Full Name|| City|| Date of joining");
     System.out.println("----------------------------------------------------------------------------------------------");
     
        for (Employee s : list) 
        {
           
            System.out.println(s.getId()+" |"+s.getfName()+" "+s.getlName()+"| " +s.getCity()+" |"+s.getdoj());
        }
        
        Collections.sort(list, Employee.eCompName);
        
        System.out.println("Sorted by Last name");
        System.out.println();
        System.out.println("Id|| Full Name|| City|| Date of joining");
        System.out.println("----------------------------------------------------------------------------------------------");
        for (Employee s : list) 
        {
           
        	System.out.println(s.getId()+"||"+s.getfName()+" "+s.getlName()+"||" +s.getCity()+"||"+s.getdoj());
        	System.out.println();
        }
        
        System.out.println("Sorted by Date of joining");
        System.out.println();
        System.out.println("Id|| Full Name|| City|| Date of joining");
        System.out.println("----------------------------------------------------------------------------------------------");

        Collections.sort(list, Employee.eCompDate);
        
        for (Employee s : list) 
        {
           
        	System.out.println(s.getId()+"||"+s.getfName()+" "+s.getlName()+"||" +s.getCity()+"||"+s.getdoj());
        	System.out.println();
        }
    }
}
    