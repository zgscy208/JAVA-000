package com.example.week8homework.dao;

import org.springframework.stereotype.Repository;

import com.example.week8homework.entity.TOrder;
@Repository
public interface TOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}