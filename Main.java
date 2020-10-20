import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String as[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DataConfig.class);
        EmployeeImplDao employeeImplDAO  = ctx.getBean(EmployeeImplDao.class);
        List<Employee> employeesrm = employeeImplDAO.getallEmployeesRM();
        for (Employee record : employeesrm) {
           System.out.print("ID : " + record.getId() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", First Name : " + record.getfName());
            System.out.print(", Last Name : " + record.getlName());
            System.out.print(", City : " + record.getCity());
            System.out.print(", Date of Joining : " + record.getJoiningDate()+"\n");
        }
        List<Employee> employeesrs = employeeImplDAO.getallEmployeesRS();
        for (Employee record : employeesrs) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", First Name : " + record.getfName());
            System.out.print(", Last Name : " + record.getlName());
            System.out.print(", City : " + record.getCity());
            System.out.print(", Date of Joining : " + record.getJoiningDate()+"\n");
        }
        List<Employee> employeesrch = employeeImplDAO.getallEmployeesRCH();
        for (Employee record : employeesrch) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", First Name : " + record.getfName());
            System.out.print(", Last Name : " + record.getlName());
            System.out.print(", City : " + record.getCity());
            System.out.print(", Date of Joining : " + record.getJoiningDate()+"\n");
        }

    }
}
