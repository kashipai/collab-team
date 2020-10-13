package com.programcreek.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.programcreek.helloworld.services.HelloWorldService;

public class Hello {
	@SuppressWarnings("resource")

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		HelloWorldService service = (HelloWorldService) context
				.getBean("HelloWorldService");
		String message = service.sayHello();
		System.out.println(message);
 
		//set a new name
		service.setName("Spring and Maven");
		message = service.sayHello();
		System.out.println(message);
		
		//addition of two values
		HelloWorldService sum = (HelloWorldService) context
				.getBean("HelloWorldService");
		int value = sum.addition(10, 20);
		System.out.println(value);

	}

}
