package com.validation.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.validation.customvalidator.PasswordValidator;
import com.validation.customvalidator.StateValidator;
import com.validation.customvalidator.ZipCodeValidator;
import com.validation.utility.StateList;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.validation")
public class AppConfig extends WebMvcConfigurerAdapter {

	/**
	 * @return
	 * 
	 * 
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setOrder(1);
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * @return
	 * 
	 *         This Bean is used when we are writing validation messages inside
	 *         message.properties file
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * @return
	 * 
	 *         This Bean is used when we are writing validation messages inside
	 *         message.properties file
	 */
	@Bean
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}
	
	
	@Bean
	public StateList statelist()
	{
		return new StateList();
	}
	
	
	@Bean
	public PasswordValidator passwordValidator()
	{
		return new PasswordValidator();
	}
	
	@Bean
	public ZipCodeValidator zipCodeValidator()
	{
		return new ZipCodeValidator();
	}
	
	@Bean
	public StateValidator stateValidator()
	{
		return new StateValidator();
	}
}
