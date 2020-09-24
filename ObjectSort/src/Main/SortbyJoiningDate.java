package Main;

import java.util.Comparator;

public class SortbyJoiningDate implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getJoiningDate().compareTo(o2.getJoiningDate());
	}

}
