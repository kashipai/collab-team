package assignment15_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Employee")
public class AppConfigTest2 {
	@Bean
	public Employee employee1() {
		return new Employee(101, person1(), "Manager");
	}

	@Bean
	public Person person1() {
		return new Person("Raman", "Nath", 45);
	}

}