package sneha.springFrameWorkDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VechileDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Vehicle obj = (Vehicle)context.getBean("Car");
		obj.drive();
		System.out.println("Number of wheels : "+obj.getNumOfWheels());

	}
}
