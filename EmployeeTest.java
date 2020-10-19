package springEmployee.JDBCtemplate;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		Employee emply = context.getBean("employee", Employee.class);
		emply.updateRow();
		emply.deleteRow(106);
		((AnnotationConfigApplicationContext) context).close();

	}

}
