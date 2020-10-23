package com.sowjanya.jpaonetomany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class App3 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sowjanya.jpaonetomany");
        appContext.refresh();
 
        CustomerService2 customerService = (CustomerService2) appContext.getBean("customerService");
        customerService.test();
       
        appContext.close();
    }
}
