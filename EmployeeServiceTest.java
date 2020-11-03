package ServiceTest;

import com.example.employeerest.Dao.EmployeeDao;
import com.example.employeerest.Service.EmployeeServiceImpl;
import com.example.employeerest.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Mock
    EmployeeDao dao;

    @Test
    public void getAllEmployeesTest() {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "John", 23, "React");
        Employee empTwo = new Employee(2, "Alex", 34, "Java");
        Employee empThree = new Employee(3, "Steve", 29, "Python");
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        Mockito.when(dao.findAll()).thenReturn(list);
        assertThat(employeeService.getallEmployee().equals(list));
    }

    @Test
    public void deleteEmployeeTest() {
        long id = 1;
        employeeService.deleteEmployee(id);
        Mockito.verify(dao, Mockito.times(1)).deleteById(id);
    }
    @Test
    public void saveEmployeeTest(){
        Employee empOne = new Employee(1, "John", 23, "React");
        Mockito.when(dao.save(empOne)).thenReturn(empOne);
        assertEquals(empOne,employeeService.addEmployee(empOne));
    }
}

