package springdependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean("client1")
	public Client getClient(Service service1) {
		return new ClientA(service1);
	}
	
	@Bean("service1")
	public Service getService() {
		return new ServiceB();
	}

}
