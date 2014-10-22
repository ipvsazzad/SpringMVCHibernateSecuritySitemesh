package com.lynas.util;


import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.addConnectionProperty("destroy-method", "close");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");				
		basicDataSource.setUrl("jdbc:mysql://localhost/hibnatedb");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("");
		return basicDataSource;
	}	
	
	private Properties hibernateProperties(){
	    Properties properties = new Properties();
	    properties.put("dialect", "org.hibernate.dialect.MySQLDialect");
	    return properties;
	}
	
	@Bean
	public AnnotationSessionFactoryBean sessionFactoryBean(){
		AnnotationSessionFactoryBean asfb = new  AnnotationSessionFactoryBean();
		asfb.setDataSource(dataSource());
		asfb.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		asfb.setHibernateProperties(hibernateProperties());
		return asfb;
	}
	
	public SessionFactory sessionFactory() {
	    return sessionFactoryBean().getObject();
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(){
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory());
		return hibernateTransactionManager;
	}
	
}
























