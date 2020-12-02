package tech.jiangchen.dynamicdatasource01.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DynamicDataSourceAspect {

    @Around(value = "@annotation(tech.jiangchen.dynamicdatasource01.config.DS) && @annotation(ds)")
    public void initDB(ProceedingJoinPoint point, DS ds) throws Throwable {
        DataSourceContextHolder.setDB(ds.value());
        point.proceed();
        DataSourceContextHolder.clearDB();
    }
}
