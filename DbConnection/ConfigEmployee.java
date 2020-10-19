package databaseConnection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class ConfigEmployee 
{
	
    @Bean(name="jdbcConfig")
    public DataSource dataSource() 
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/servletexercise");
        dataSource.setUsername("root");
        dataSource.setPassword("MySql@123");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        template.setResultsMapCaseInsensitive(true);
        return template;
        
      
}
    @Bean
    public Employees employee()
    {
    	return new Employees();
    }
}

