package com.sowjanya.jpaspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App1
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sowjanya.jpaspring");
        appContext.refresh();
 
        CustomerService1 customerService = (CustomerService1) appContext.getBean("customerService");
        customerService.test();
       
        appContext.close();
    }
}
