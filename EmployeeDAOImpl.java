package springMVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDAOImpl implements EmployeeDao {
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	public int add(Employee employee) {
		String sql = "insert into employee(id,name) values(?,?)";
		
		try {
			int counter = jdbcTemplate.update(sql, new Object[] {employee.getId(), employee.getName()});
			return counter;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	public List<Employee> read() {
		// TODO Auto-generated method stub
		
		List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM employee", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();

				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
			

				return employee;
			}

		});

		return employeeList;
	}
	public List<Employee> findEmployeeById(int id) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = jdbcTemplate.query("SELECT * FROM employee where id = '?'", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();

				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
			

				return employee;
			}

		});

		return employeeList;
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from employee where id=?";

		try {

			int counter = jdbcTemplate.update(sql, new Object[] { id });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
