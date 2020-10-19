package spring.profile.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages="spring.profile.annotation")
public class CustomerConfig {
	@Profile("dev")
	@Bean(name="customer")
	public Customer getDevCustomer()
	{
		return new Customer("John","Bangalore");
	}
	
	@Profile("prod")
	@Bean(name="customer")
	public Customer getProdCustomer()
	{
		return new Customer("Martin","Mangalore");
	}
}
