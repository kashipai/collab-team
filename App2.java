package com.sowjanya.jpaonetomany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App2 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sowjanya.jpaonetomany");
        appContext.refresh();
 
        CustomerService customerService = (CustomerService) appContext.getBean("customerService");
        customerService.test();
       
        appContext.close();
    }
}
