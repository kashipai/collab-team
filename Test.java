package employee.spring.TEST;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import employee.spring.API.Employee;
import employee.spring.DAO.EmployeeDaoImpl;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		EmployeeDaoImpl emply = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);
		Employee employee1 = new Employee();
		employee1.setEmployeeID(107);
		employee1.setFirstName("Virat");
		employee1.setLastName("Kohli");
		employee1.setSalary(30000);
		employee1.setAge(28);
		emply.insert(employee1);
		Employee employee3 = new Employee(103, "Amir", "Khan", 30000, 29);
		emply.update(employee3);
		Employee employee2 = emply.getEmployee(103);
		System.out.println("The Employee Details : " + employee2);
		emply.delete(107);
		((AnnotationConfigApplicationContext) context).close();
	}

}
