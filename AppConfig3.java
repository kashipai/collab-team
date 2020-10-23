package com.sowjanya.jpaonetomany;

import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = {"com.sowjanya.jpaonetomany"})
public class AppConfig3 {
	
	 @Bean
	    public LocalEntityManagerFactoryBean entityManagerFactory() {
	        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
	        factoryBean.setPersistenceUnitName("TestDB");
	         
	        return factoryBean;
	    }
	     
	    @Bean
	    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	        JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(entityManagerFactory);
	         
	        return transactionManager;
	    } 

}
