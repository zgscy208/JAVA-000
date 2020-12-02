package tech.jiangchen.dynamicdatasource01.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatasourceConfig {

    @Bean(name = DS.MASTER)
    @ConfigurationProperties(prefix = "db0")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = DS.SLAVE)
    @ConfigurationProperties(prefix = "db1")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap<>();
        dsMap.put(DS.MASTER, master());
        dsMap.put(DS.SLAVE, slave());
        dynamicDataSource.setTargetDataSources(dsMap);//相应的数据库源会在切换的时候从AbstractRoutingDataSource的Map<Object, Object> targetDataSources中获取。所以这里要添加所有的数据源
        return dynamicDataSource;
    }

    /**
     * 配置@Transactional注解事物
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
