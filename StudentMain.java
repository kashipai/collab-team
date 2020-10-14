package exercise2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

public class StudentMain {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		Student student = ctx.getBean(Student.class);
		student.setStream("Commerce");
		student.display();

	}
}
