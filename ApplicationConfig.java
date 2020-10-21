package exercise1610;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "exercise1610")
@PropertySource(value = { "classpath:application.properties" })
public class ApplicationConfig {

    @Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

   @Bean
   public DataSource dataSource() {
	  
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName(driver);
       dataSource.setUrl(url);
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       return dataSource;
   }

   @Bean
   public JdbcTemplate jdbcTemplate(DataSource dataSource) {
       JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
       jdbcTemplate.setResultsMapCaseInsensitive(true);
       return jdbcTemplate;
   }

}