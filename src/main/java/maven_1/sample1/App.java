package maven_1.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/*
		 * Resource resource=new ClassPathResource("Bean.xml"); BeanFactory factory=new
		 * XmlBeanFactory(resource);
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Student student = new Student("Vaishnavi", "VA001", "123456789");
		Student student = (Student) context.getBean("Student1");
		student.displayInfo();
	}
}
