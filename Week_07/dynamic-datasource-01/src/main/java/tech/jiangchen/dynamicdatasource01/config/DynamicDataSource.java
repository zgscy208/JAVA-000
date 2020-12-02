package tech.jiangchen.dynamicdatasource01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    protected static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("DynamicDataSource#determineCurrentLookupKey ... 数据源为" + DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();// 在DataSourceContextHolder经过set之后，这里get
    }
}
