package Sample1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

	@Bean
	public Employee employee() {
		return new Employee("Vaishnavi","RT006","987654321");
	}

	@Bean
	public Department department() {
		return new Department(employee(),"Marketing","RTM01");
	}
}
