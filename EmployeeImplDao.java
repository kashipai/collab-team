import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImplDao implements EmployeeDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Employee> getallEmployeesRS() {
       String SQL = "select * from employees";
       return jdbcTemplateObject.query(SQL, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
              List<Employee> list = new ArrayList<Employee>();
              while (rs.next()){
                  Employee employee = new Employee();
                  employee.setId(rs.getInt("id"));
                  employee.setAge(rs.getInt("age"));
                  employee.setfName(rs.getString("first"));
                  employee.setlName(rs.getString("last"));
                  employee.setCity(rs.getString("city"));
                  employee.setJoiningDate(rs.getDate("joiningdate"));
                  list.add(employee);
              }
              return list;
            }
        });
    }

    @Override
    public List<Employee> getallEmployeesRM() {
        String SQL = "select * from employees";
        List <Employee> employees = jdbcTemplateObject.query(SQL, new EmployeeMapper());
        return employees;
    }

    @Override
    public List<Employee> getallEmployeesRCH() {
        String SQL = "select * from employees";
        List<Employee> list = new ArrayList<Employee>();
        jdbcTemplateObject.query(SQL, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                while (rs.next()){
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setAge(rs.getInt("age"));
                    employee.setfName(rs.getString("first"));
                    employee.setlName(rs.getString("last"));
                    employee.setCity(rs.getString("city"));
                    employee.setJoiningDate(rs.getDate("joiningdate"));
                    list.add(employee);
                }
            }
        });
        return list;
    }
}
