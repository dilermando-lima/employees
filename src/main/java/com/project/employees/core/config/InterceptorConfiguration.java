package com.project.employees.core.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class InterceptorConfiguration extends WebMvcConfigurationSupport {
    
    @Autowired
	RequestInterceptor requestInterceptor;
	

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		
		super.setApplicationContext(applicationContext);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
    }
    
}
