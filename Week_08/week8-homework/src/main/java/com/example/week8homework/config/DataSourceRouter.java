package com.example.week8homework.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO
 * </p>
 *
 * @author xingpeng
 * @date 2020/12/1 4:35 下午
 **/
@Slf4j
public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("======current dbtype connection is ===: {}",DbContextHolder.getDbType());
        return DbContextHolder.getDbType();
    }
}
