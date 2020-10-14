package Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		HelloWorld service = (HelloWorld) context.getBean("helloWorld");
		String message = service.sayHello();
		System.out.println(message);


		service.setName("I am Anush");
		message = service.sayHello();
		System.out.println(message);

	}

}
