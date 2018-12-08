package com.niit.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableWebMvc //<mvc:annotation-driven> tag in dispather-servlet.xml file
@ComponentScan(basePackages="com.niit")  
public class WebConfigure extends WebMvcConfigurerAdapter {
@Bean(name="multipartResolver")
public CommonsMultipartResolver commonsMultupartResolver()
{
	CommonsMultipartResolver commonsMultupartResolver=new CommonsMultipartResolver();
	return commonsMultupartResolver;
}
}
