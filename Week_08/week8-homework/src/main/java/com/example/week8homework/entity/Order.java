package com.example.week8homework.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
    private Long id;

    private Long accId;

    private Long goodsId;

    private Integer payAmount;

    private Integer payStatus;

    private Date payTime;

    private Date refundTime;

    private Date createTime;

    private Date updateTime;

}