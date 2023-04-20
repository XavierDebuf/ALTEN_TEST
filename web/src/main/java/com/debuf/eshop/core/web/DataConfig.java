package com.debuf.eshop.core.web;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages ="com.debuf.eshop.core.repository")
public class DataConfig {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://${MYSQL_HOST:localhost}:3306/Product");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("Clams34G!1977");
        return dataSourceBuilder.build();
    }
}