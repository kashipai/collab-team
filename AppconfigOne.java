package junit.testing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages="junit.testing")
@Profile("Addition")
public class AppconfigOne {

	

}
