package com.smk.jdbcassignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(LenovoConfig.class);
        LenovoDaoimpl implobj=(LenovoDaoimpl) context.getBean("implement");
        implobj.insert(new lenovo(108,"Yoga105"));
    }
}
