import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {
    public void setDataSource(DataSource dataSource);
    public List<Employee> getallEmployeesRS();
    public List<Employee> getallEmployeesRM();
    public List<Employee> getallEmployeesRCH();
}
