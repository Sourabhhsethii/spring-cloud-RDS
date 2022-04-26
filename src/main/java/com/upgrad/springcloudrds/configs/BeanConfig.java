package com.upgrad.springcloudrds.configs;

import io.awspring.cloud.jdbc.config.annotation.RdsInstanceConfigurer;
import io.awspring.cloud.jdbc.datasource.TomcatJdbcDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RdsInstanceConfigurer _instanceConfigurer(){
        return () ->{
            TomcatJdbcDataSourceFactory dataSourceFactory = new TomcatJdbcDataSourceFactory();
            dataSourceFactory.setInitialSize(10);
            dataSourceFactory.setValidationQuery("SELECT 1 FROM DUAL");
            return dataSourceFactory;
        };
    }
}
