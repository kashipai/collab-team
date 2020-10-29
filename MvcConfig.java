package springMvcLibrary.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springMvcLibrary.Dao.LibraryDao;
import springMvcLibrary.Dao.LibraryDaoImpl;

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = {"springMvcLibrary.Dao, springMvcLibrary.Model, springMvcLibrary.Config, springMvcLibrary.Controller"})
	public class MvcConfig implements WebMvcConfigurer {

		@Bean
		public DataSource getDataSource() {
			DriverManagerDataSource datasource = new DriverManagerDataSource();
			datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			datasource.setUrl("jdbc:mysql://localhost:3306/servletexercise");
			datasource.setUsername("root");
			datasource.setPassword("MySql@123");
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
		public LibraryDao getDoa() {
			return new LibraryDaoImpl(getDataSource());
			
		}
	}

