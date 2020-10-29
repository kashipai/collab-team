package demo_spring_mvc.student.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import demo_spring_mvc.student.dao.StudentDao;
import demo_spring_mvc.student.dao.StudentDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "demo_spring_mvc.student.dao,demo_spring_mvc.student.model,demo_spring_mvc.student.config,demo_spring_mvc_student.controller")
public class SpringMvcConfig implements WebMvcConfigurer {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/database4");
		datasource.setPassword("naruto#420");
		datasource.setUsername("root");
		return datasource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/Views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public StudentDao getStudentDoa() {
		return new StudentDaoImpl(getDataSource());
		
	}
}
