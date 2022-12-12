package com.example.demo.more.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2021/12/30 18:43
 */
@Configuration
public class DataSourceConfig {

    /**
     * 第一个数据源
     * @return
     */
    @Primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    /**
     * 第二个数据源
     * @return
     */
    @Primary
    @Bean(name = "secondDataSource")
    @Qualifier("secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


}
