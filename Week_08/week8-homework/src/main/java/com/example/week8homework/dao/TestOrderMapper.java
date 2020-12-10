package com.example.week8homework.dao;

import org.springframework.stereotype.Repository;

import com.example.week8homework.entity.TestOrder;
@Repository
public interface TestOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(TestOrder record);

    int insertSelective(TestOrder record);

    TestOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(TestOrder record);

    int updateByPrimaryKey(TestOrder record);
}