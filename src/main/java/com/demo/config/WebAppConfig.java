package com.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.demo")
@PropertySource("classpath:database.properties")
public class WebAppConfig {
	
	@Autowired
	Environment environment;

	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		datasource.setUrl(environment.getRequiredProperty("jdbc.url"));
		datasource.setUsername(environment.getRequiredProperty("jdbc.username"));
		datasource.setPassword(environment.getProperty("jdbc.password"));
		
		return datasource;
	}
	
	public Properties getHibernateProperties() {
		
		Properties prop = new Properties();
		prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
		return prop;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan(new String[] {"com.demo.entity"});
		factory.setHibernateProperties(getHibernateProperties());
		
		return factory;
	}

}
