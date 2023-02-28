package com.test.all.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = "testDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource opDbDataSource() {
        return DataSourceBuilder.create().build();
    }

}
