package springAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		AccountHolder accHolder = context.getBean(AccountHolder.class);
		Transactions trans = context.getBean(Transactions.class);
		
		System.out.println("Account number "+accHolder.getAccNumber());
		System.out.println("Name "+accHolder.getName());
		System.out.println("Contact "+accHolder.getEmail());
		System.out.println("Last transaction "+trans.getTransDetails()+" - "+trans.getAmount());
	}

}
