package java_ex;

import java.util.Comparator;

public class LastNameSorter implements Comparator<Employee1>  {
	public int compare(Employee1 o1, Employee1 o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
