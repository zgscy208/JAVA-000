package com.example.week8homework.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

/**
 * <p>TODO
 * </p>
 *
 * @author xingpeng
 * @date 2020/12/1 5:58 下午
 **/
@Configuration
public class DataSourceConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        //return DataSourceBuilder.create().build();
        return new HikariDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave() {
        //return DataSourceBuilder.create().build();
        return new HikariDataSource();

    }

    @Bean
    @Primary
    public DataSourceRouter dataSource(@Qualifier("master") DataSource masterDataSource ,
                                       @Qualifier("slave") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSourceMap = new HashMap<>();
        targetDataSourceMap.put(DbContextHolder.DbType.master, masterDataSource);
        targetDataSourceMap.put(DbContextHolder.DbType.slave, slaveDataSource);
        DataSourceRouter dataSourceRouter = new DataSourceRouter();
        dataSourceRouter.setTargetDataSources(targetDataSourceMap);
        dataSourceRouter.setDefaultTargetDataSource(masterDataSource);
        return dataSourceRouter;
    }

}
