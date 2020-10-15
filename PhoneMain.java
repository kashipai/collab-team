package sneha.springAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PhoneMain {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigJavaCode.class);
	    Phone phone = (Phone) context.getBean("apple");
	    phone.getPhone();
	}
}
