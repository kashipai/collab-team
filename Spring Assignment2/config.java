package com.smk.Assignment2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
	
	@Bean
	public poco getsspecs()
	{
		return new poco();
	}
	
	@Bean
	public camerasensor getcs()
	{
		return new sonysensor();
	}

}
