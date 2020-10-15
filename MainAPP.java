package spring.frame.work;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@SuppressWarnings("resource")

		AnnotationConfigApplicationContext contextA = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloWorld obj = contextA.getBean("helloWorld", HelloWorld.class);
		System.out.println("college obj   "+obj);
		obj.sayHello();
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		College objb = context.getBean("college", College.class);
		System.out.println("college obj   "+objb);
		objb.Test();
		contextA.close();
		context.close();

	}

}
