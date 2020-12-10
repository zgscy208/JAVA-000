package com.example.week8homework.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsImageUrl;

    private Integer goodsPrice;

    private Integer pubStatus;

    private Date createTime;

    private Date updateTime;

}