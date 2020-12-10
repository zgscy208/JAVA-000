package com.example.week8homework.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO
 * </p>
 *
 * @author xingpeng
 * @date 2020/12/1 6:37 下午
 **/
@Aspect
@Component
@Slf4j
public class MasterAspect {

    @Around("@annotation(master)")
    public Object process(ProceedingJoinPoint joinPoint, Master master) throws Throwable {
        try {
            log.info("==== MasterAspect put master flag into DbContextHolder dbContextStackHolder");
            DbContextHolder.setDbType(DbContextHolder.DbType.master);
            return joinPoint.proceed();
        } finally {
            DbContextHolder.popDbType();
            log.info("==== MasterAspect pop master flag out DbContextHolder dbContextStackHolder");
        }
    }
}
