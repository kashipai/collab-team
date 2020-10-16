package assignment15_10;

import org.springframework.context.annotation.*;

@Configuration
@Profile("Student")
public class AppConfigTest1 {
	@Bean
	public Student student1() {
		return new Student(person1(), 36, "Science");
	}

	@Bean
	public Person person1() {
		return new Person("Alice", "John", 15);
	}

}
