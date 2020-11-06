package com.example.springSecurity.Config;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.example.springSecurity.Service.UserServices;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
/*	@Bean
	public ClassLoaderTemplateResolver secondaryTemplateResolver() {
	    ClassLoaderTemplateResolver secondaryTemplateResolver = new ClassLoaderTemplateResolver();
	    secondaryTemplateResolver.setPrefix("/views/");
	    secondaryTemplateResolver.setSuffix(".html");
	    secondaryTemplateResolver.setTemplateMode(TemplateMode.HTML);
	    secondaryTemplateResolver.setCharacterEncoding("UTF-8");
	    secondaryTemplateResolver.setOrder(1);
	    secondaryTemplateResolver.setCheckExistence(true);
	    
	    return secondaryTemplateResolver;
	}*/
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserServices();
    }
    
    @Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authProvider());
	 }
	 
	   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/save").permitAll()
            .antMatchers("/newPerson").hasAnyAuthority("ADMIN")
            .antMatchers("/list").hasAnyAuthority("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/accessDenied")
            ;
    }
    
    
}
