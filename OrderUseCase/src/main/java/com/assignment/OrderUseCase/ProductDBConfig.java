package com.assignment.OrderUseCase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory")
public class ProductDBConfig {
	
	/*
	 * @Primary
	 * 
	 * @Bean(name="datasource")
	 * 
	 * @ConfigurationProperties(prefix="spring.product.datasource") public
	 * DataSource dataSource() { return (DataSource)
	 * DataSourceBuilder.create().build(); }
	 * 
	 * @Primary
	 * 
	 * @Bean(name = "entityManagerFactory") public
	 * LocalContainerEntityManagerFactoryBean
	 * entityManagerFactory(EntityManagerFactoryBuilder builder
	 * ,@Qualifier("datasource") DataSource dataSource) { { return builder
	 * .dataSource((javax.sql.DataSource) dataSource)
	 * .packages("com.assignment.OrderUseCase") .build(); } }
	 * 
	 * //TransactionManager
	 * 
	 * @Primary
	 * 
	 * @Bean public PlatformTransactionManager transactionManager(
	 * final @Qualifier("entityManagerFactory") EntityManagerFactory
	 * entityManagerFactory) { return new
	 * JpaTransactionManager(entityManagerFactory); }
	 */
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.product.datasource")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder
					.create()
					.build();
	}
	@Bean(name="camundaBpmDataSource")
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource secondaryDataSource() {
	  return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder
					.dataSource(mysqlDataSource())
					.packages("com.assignment.OrderUseCase")			
					.build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager mysqlTransactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
