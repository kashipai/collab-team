package Main;

import java.util.Comparator;

public class SortbyLastname implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getLastName().compareTo(o2.getLastName());
	}
	
}


