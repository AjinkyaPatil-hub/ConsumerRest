package com.scp.config;
	
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@ComponentScan(basePackages = {"com.scp.*"})
public class SpringHiberConfig {	
	static {
		System.out.println("inside spring hibernate integration");
	}


/*	@Bean("ds")
	public BasicDataSource basicDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/restdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("sf")
	public LocalSessionFactoryBean getSessionFactory(){
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(basicDataSource());
		sf.setHibernateProperties(hibernateProperties());
		sf.setPackagesToScan("com.scp.entities");
		return sf;
	}

	private Properties hibernateProperties() {
		Properties props = new Properties();
		props.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		props.put(Environment.HBM2DDL_AUTO,"update");
		props.put(Environment.SHOW_SQL,"true");
		return props;
	}
*/
	
	@Bean
	public InternalResourceViewResolver prepareViewResoulver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setViewClass(JstlView.class);
		view.setPrefix("/WEB-INF/views/");
		view.setSuffix(".jsp");
		return view;
	}

}
