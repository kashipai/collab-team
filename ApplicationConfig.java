package exercise2;

import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {
	@Bean
	public Student student1() {
		return new Student(18, "Meera", address1());
	}

	@Bean
	public Address address1() {
		return new Address("Mysore", "Karnataka", "India");
	}
}
