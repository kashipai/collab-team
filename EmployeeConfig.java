package springEmployee.JDBCtemplate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "springEmployee.JDBCtemplate")
@PropertySource("classpath:database.properties")
public class EmployeeConfig {
	
	 @Autowired
	    private Environment env;
	 
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("database.driver"));
	        dataSource.setUrl(env.getRequiredProperty("database.url"));
	        dataSource.setUsername(env.getRequiredProperty("database.username"));
	        dataSource.setPassword(env.getRequiredProperty("database.password"));
	        return dataSource;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
	 
}
