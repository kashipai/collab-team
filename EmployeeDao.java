package springMVC;

import java.util.List;

public interface EmployeeDao {
	public int add(Employee employee);
	public List<Employee> read();

	public List<Employee> findEmployeeById(int id);

	public int delete(int id);
}
