import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Employee employee(){
        return new Employee("Harsha",21,address());
    }
    @Bean
    public Address address(){
        return new Address(12,"1st Street","TB Road");
    }

}
