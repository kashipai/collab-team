package springMVC.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springMVC.Dao.CustomerDao;
import springMVC.Dao.CustomerDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"springMVC.Dao, springMVC.Model, springMVC.Config, springMVC.Controller"})
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/demo");
        datasource.setUsername("root");
        datasource.setPassword("12345");
        return datasource;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CustomerDao getDoa() {
        return new CustomerDaoImpl(getDataSource());

    }
}
