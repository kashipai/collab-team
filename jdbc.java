package com.sowjanyajain.springjdbc;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;


@Component
public class SpringJdbc {

	public static void main(String[] args)  {	
		ApplicationContext factory=new AnnotationConfigApplicationContext(AppConfig.class);
        GetDatabase database=factory.getBean(GetDatabase.class);
        database.insertData();
	}

}