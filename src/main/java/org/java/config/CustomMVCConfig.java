package org.java.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.java")
@EnableWebMvc // Default Servlet Handler
@EnableTransactionManagement
public class CustomMVCConfig extends WebMvcConfigurerAdapter {

	// handler to serve static resources - under web application root,classpath etc.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		//registry.addResourceHandler("/webapp/**").addResourceLocations("/webapp/");
	}

	// handler to delegate unhandled requests by forwarding to theServlet
	// container's "default" servlet
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	//View Resolver
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}


	/*
	 * @Bean public EmployeeController employeeController() { return new
	 * EmployeeController(); }
	 */

	/*
	 * public void jdbc() { EmbeddedDatabaseBuilder builder = new
	 * EmbeddedDatabaseBuilder(); EmbeddedDatabase db =
	 * builder.type(EmbeddedDatabaseType.H2).script("schema.sql").script(
	 * "test-data.sql").build(); // do stuff against the db (EmbeddedDatabase
	 * extends javax.sql.DataSource) db.shutdown();
	 * 
	 * }
	 */

	/*
	 * Added jdbc:embedded-database for h2 
	 * Added scripts for create and insert
	 */
	@Bean 
	public DataSource dataSource() {
		System.out.println("In dataSource method");
		return new EmbeddedDatabaseBuilder()
				.generateUniqueName(false)
				.setName("testdb")
				.setType(EmbeddedDatabaseType.H2)
				.addScripts("classpath:sql/create-table.sql","classpath:sql/insert-data.sql")
				.setScriptEncoding("UTF-8")
				.ignoreFailedDrops(true)
				.build();
	}

	/*
	 * Hibernate Transaction Manager
	 * Created bean for Treanscation MAnager with Session Factory as property
	 */

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(sessionFactory);
		return htm;
	}

	@Bean
	@Autowired
	public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory){
		return new HibernateTemplate(sessionFactory);
	}

	/*
	 * AnnotationSessionFactoryBean 
	 * Setting values for dataSource, annotated classes and hibernate properties
	 */	
	@Bean
	public AnnotationSessionFactoryBean getSessionFactory(){
		AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
		asfb.setDataSource(dataSource());
		asfb.setHibernateProperties(getHibernateProperties());        
		asfb.setPackagesToScan(new String[]{"org.java"});
		return asfb;
	}

	//Setting hibernate properties 
	@Bean
	public Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", true);

		return properties;
	}

	//
	/*
	 * @Bean public DataSource getDataSource() { DriverManagerDataSource ds = new
	 * DriverManagerDataSource(); ds.setDriverClassName("org.h2.Driver"); return ds;
	 * }
	 */
}
