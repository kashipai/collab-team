//package threadcheck;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.LNEG;

class employee implements Comparable<employee>
{
	int empno;
	String fname,lname;
	java.util.Date dateofjoining;
	
	public employee(int empno, String fname, String lname, java.util.Date dateofjoining) {
		super();
		this.empno = empno;
		this.fname = fname;
		this.lname = lname;
		this.dateofjoining = dateofjoining;
	}
	
	
	
	@Override
	public String toString() {
		return "employee [empno=" + empno + ", fname=" + fname + ", lname=" + lname + ", date of joining=" + dateofjoining
				+ "]";
	}
	@Override
	public int compareTo(employee e) {
		
		return((dateofjoining.compareTo(e.dateofjoining)>0)?1:-1);
	}
	
}

public class empdate {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		List<employee> vals=new ArrayList<>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		vals.add(new employee(1, "Sumantha", "mk",dateFormat.parse("2020-06-20")));
		vals.add(new employee(2, "Avinash", "as",dateFormat.parse("2020-08-12")));
		vals.add(new employee(3, "Ram", "singh",dateFormat.parse("2020-08-05")));
		
		Collections.sort(vals);
		//vals.sort(null);
		System.out.println("Sort by Date of Joining:-\n");
		for(employee s : vals)
		{
			System.out.println(s+"\n");
		}

	}

}
