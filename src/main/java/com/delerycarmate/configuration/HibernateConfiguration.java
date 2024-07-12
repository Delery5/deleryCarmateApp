package com.delerycarmate.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration // Indicates that this class contains Spring bean definitions
@EnableTransactionManagement // Enables Spring's annotation-driven transaction management
@ComponentScan({ "com.delerycarmate.configuration" }) // Specifies the base package to scan for Spring components
@PropertySource(value = { "classpath:application.properties" }) // Specifies the properties file to load
public class HibernateConfiguration {

    @Autowired
    private Environment environment; // Spring Environment to access properties

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.delerycarmate.model" }); // Package to scan for entity classes
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName")); // JDBC driver class name
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url")); // JDBC URL
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username")); // Database username
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password")); // Database password
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect")); // Hibernate dialect
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql")); // Show SQL in console
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql")); // Format SQL
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s); // Set the session factory for transaction manager
        return txManager;
    }
}

