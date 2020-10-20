package employee.spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import employee.spring.API.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbctemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Employee employee) {
		String sql = "INSERT INTO database2.emptable Values(?,?,?,?,?)";
		Object[] obj = { employee.getEmployeeID(), employee.getFirstName(), employee.getLastName(),
				employee.getSalary(), employee.getAge() };
		jdbcTemplate.update(sql, obj);
		System.out.println("Employee Inserted!!!");
	}

	public void delete(int EmpId) {
		jdbcTemplate.update("DELETE from database2.emptable WHERE EmpId = ? ", +EmpId);
		System.out.println("Employee with Employee Id " + EmpId + " Deleted!!");
	}

	public void update(Employee employee) {
		String sql = "UPDATE database2.emptable SET FirstName='" + employee.getFirstName() + "',LastName='"
				+ employee.getLastName() + "',Salary='" + employee.getSalary() + "',Age='" + employee.getAge()
				+ "' WHERE EmpId='" + employee.getEmployeeID() + "' ";
		jdbcTemplate.update(sql);
		System.out.println("Employee Updated!!!");
	}

	public Employee getEmployee(int EmpId) {
		String sql = "SELECT * FROM database2.emptable WHERE EmpId = ?";
		RowMapper<Employee> rowMapper = new RowMapperImpl();
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, EmpId);
		return employee;
	}

}
