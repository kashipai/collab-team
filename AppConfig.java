package spring.frame.work;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="spring.frame.work")
public class AppConfig {
	
/*	@Bean
	public Teacher teachBean() {
		return new JavaBackend();
	}
	
	@Bean
	public Principal principalBean() {
		return new Principal();
		
	}
	
	@Bean(name = "college")
	public College collegeBean() { .
		College clg = new College();
		clg.setPrincipal(principalBean());
		clg.setTeacher(teachBean());
		return clg;
		
	}
	

	
	@Bean(name = "hello")
	public HelloWorld HelloBean() {  
		HelloWorld hlo = new HelloWorld();
		return hlo;
	}*/
	
}

