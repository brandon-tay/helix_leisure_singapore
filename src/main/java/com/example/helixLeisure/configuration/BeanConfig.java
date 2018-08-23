package com.example.helixLeisure.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class BeanConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.example.helixLeisure.model" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
	 
		return em;
	}
	 
	@Bean
	public DataSource dataSource(){
		HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(100);
        ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        ds.addDataSourceProperty("url", "jdbc:mysql://localhost:3306/database");
        ds.addDataSourceProperty("user", "user");
        ds.addDataSourceProperty("password", "password");
        ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);
        
        return ds;
	}
	 
	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	        
		return properties;
	}
	
}
