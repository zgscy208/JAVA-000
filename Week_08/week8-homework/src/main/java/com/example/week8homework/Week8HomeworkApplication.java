package com.example.week8homework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication()
@MapperScan("com.example.week8homework.dao")

public class Week8HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week8HomeworkApplication.class, args);
    }

}
