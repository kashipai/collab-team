package employee.spring.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		System.out.println("Database Updated!!!");
	}

	public void delete(int EmpId) {
		jdbcTemplate.update("DELETE from database2.emptable WHERE EmpId = ? ", +EmpId);
		System.out.println("Employee witth Employee Id " + EmpId + " Deleted!!");
	}
}
