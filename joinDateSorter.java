package java_ex;

import java.util.Comparator;

public class joinDateSorter implements Comparator<Employee2>  {
	public int compare(Employee2 o1, Employee2 o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
