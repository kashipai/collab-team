package employee.spring.DAO;

import employee.spring.API.Employee;

public interface EmployeeDao {
	public void insert(Employee employee);

	public void delete(int EmpID);
}
