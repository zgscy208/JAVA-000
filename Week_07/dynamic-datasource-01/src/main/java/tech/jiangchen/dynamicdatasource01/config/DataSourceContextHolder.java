package tech.jiangchen.dynamicdatasource01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceContextHolder {
    protected static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
    /**
     * 管理多数据源的: ThreadLocal类 ThreadLocal用作保存数据库源的key就可以了，相应的数据库源会在切换的时候从AbstractRoutingDataSource的Map<Object, Object> targetDataSources中获取。
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     */
    public static void setDB(String dbType) {
        log.info("设置为{" + dbType + "}数据源");
        CONTEXT_HOLDER.set(dbType);
    }

    /**
     * 获取数据源
     *
     * @return String
     */
    public static String getDB() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDB() {
        CONTEXT_HOLDER.remove();
    }
}
