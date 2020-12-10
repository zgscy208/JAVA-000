package com.example.week8homework.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * <p>TODO
 * </p>
 *
 * @author xingpeng
 * @date 2020/12/1 4:38 下午
 **/
public class DbContextHolder {

    public enum DbType {
        master,slave
    }

    /**
     * 这里把List当成一个后进先出的栈使用
     */

    private static final ThreadLocal<List<DbType>> dbContextStackHolder = new ThreadLocal<>();

    public static DbType getDbType() {
        List<DbType> dbContextStack = dbContextStackHolder.get();
        if (CollectionUtils.isEmpty(dbContextStack)) {
            return DbType.master;
        }
        return dbContextStack.get(dbContextStack.size()-1);
    }

    public static void setDbType(DbType dbType) {
        if (null != dbType) {
            List<DbType> dbContextStack = dbContextStackHolder.get();
            if (CollectionUtils.isEmpty(dbContextStack)) {
                dbContextStack = new ArrayList<>();
            }
            dbContextStack.add(dbType);
            dbContextStackHolder.set(dbContextStack);
        }
    }

    /**
     * 删除dbContextStack中的当前DbType
     */
    public static void popDbType() {
        List<DbType> dbContextStack = dbContextStackHolder.get();
        if (null != dbContextStack && dbContextStack.size() > 0) {
            dbContextStack.remove(dbContextStack.get(dbContextStack.size()-1));
        }
    }

}
