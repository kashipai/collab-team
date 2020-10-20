import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setAge(rs.getInt("age"));
        employee.setfName(rs.getString("first"));
        employee.setlName(rs.getString("last"));
        employee.setCity(rs.getString("city"));
        employee.setJoiningDate(rs.getDate("joiningdate"));
        return employee;
    }
}
