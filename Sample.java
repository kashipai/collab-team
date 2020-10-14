import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Sample {
    public static void main(String as[]) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Employee employee = ctx.getBean(Employee.class);
        Address address = ctx.getBean(Address.class);
        System.out.println("Employee Name : " +employee.getName());
        System.out.println("Employee Age : " +employee.getAge());
       System.out.println("Address : " +employee.getAddrs().getDoorNo());
        System.out.println("          " + address.getStreet());
        System.out.println("          " + address.getArea());
    }

}