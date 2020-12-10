package com.example.week8homework.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Account {
    private Long id;

    private String accName;

    private String passWord;

    private String nickName;

    private Integer status;

    private Date createTime;

    private Date updateTime;

}