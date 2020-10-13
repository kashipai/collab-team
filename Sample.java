import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample {
    public static void main(String as[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Employee employee = (Employee)context.getBean("employee");
        Address address = (Address)context.getBean("address");
        System.out.println("Employee Name : " +employee.getName());
        System.out.println("Employee Age : " +employee.getAge());
       System.out.println("Address : " +employee.getAddrs().getDoorNo());
        System.out.println("          " + address.getStreet());
        System.out.println("          " + address.getArea());
    }

}