package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class HandlerClass {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		ArrayList<Employee> employeArray = new ArrayList<Employee>();
		employeArray.add(new Employee("Max","Planck","RT00003",sdf.parse("2020-05-18")));
		employeArray.add(new Employee("Max","Born","RT00001",sdf.parse("2015-10-21")));
		employeArray.add(new Employee("Jen","Tile","RT00002",sdf.parse("2018-07-12")));


        Collections.sort(employeArray, new SortbyLastname());
        System.out.println("Sorted by Last Name");
        for (int i=0; i<employeArray.size(); i++) 
            System.out.println(employeArray.get(i));
        
        Collections.sort(employeArray, new SortbyJoiningDate());
        System.out.println("\nSorted by Joining Date");
        for (int i=0; i<employeArray.size(); i++) 
            System.out.println(employeArray.get(i));
        
	}

}
