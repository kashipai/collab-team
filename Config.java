package rowMapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

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
@PropertySource(value = { "classpath:application.properties" })

public class Config
{
    @Autowired
    private Environment env;
    
    @Bean(name = "datasource")
    public DataSource dataSource() throws Exception
    {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
    	JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        
        return template;   
    }
    
    @Bean(name = "libraryBean")
    public Library lib()
    {
    	return new Library();
    }
  
    @Bean(name = "callback")
    public CallbackHandler callbackHandler()
    {
    	return new CallbackHandler();
    }
    
    @Bean
    public RsExtractor extractor()
    {
    	return new RsExtractor();
    }
    
    @Bean
    public LibraryMapper libMap()
    {
    	return new LibraryMapper();
    }
 
    @Bean
    public LibraryDaoImpl daoBean()
    {
    	return new LibraryDaoImpl();
    }
}


