package exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student=(Student)context.getBean("student1");
		student.display();
		
		System.out.println();
		student.setStream("Arts");
		student.display();
		
	}
}
