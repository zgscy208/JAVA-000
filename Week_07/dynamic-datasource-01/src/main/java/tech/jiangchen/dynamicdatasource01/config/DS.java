package tech.jiangchen.dynamicdatasource01.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//用来修饰注解的主键，这里jvm加载class时，注解也要存在
@Target({ElementType.METHOD, ElementType.TYPE})//用来表示注解的主体是什么
public @interface DS {

    /**
     * master
     */
    String MASTER = "master";
    /**
     * slave
     */
    String SLAVE = "slave";

    String value() default MASTER;
}
