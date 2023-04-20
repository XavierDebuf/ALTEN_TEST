package com.debuf.eshop.core.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJdbcRepositories(basePackages = "com.debuf.eshop.core.repository.ProductRepositoryInterface")
public class SpringDataSource extends AbstractJdbcConfiguration {

    @Bean("dataSource")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/products?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("Clams34G!1977");
        return dataSource;
    }
    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource)
    {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}