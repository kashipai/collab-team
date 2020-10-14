package springdependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDependencyInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
         
	        Client client1 = (Client) appContext.getBean("client1");
	        client1.doSomething();
	         

	}

}
