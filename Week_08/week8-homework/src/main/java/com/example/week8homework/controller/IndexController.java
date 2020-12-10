package com.example.week8homework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.week8homework.config.Master;
import com.example.week8homework.config.Slave;
import com.example.week8homework.dao.AccountMapper;
import com.example.week8homework.dao.GoodsMapper;
import com.example.week8homework.dao.OrderMapper;
import com.example.week8homework.entity.Account;
import com.example.week8homework.entity.Goods;
import com.example.week8homework.entity.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>TODO
 * </p>
 *
 * @author xingpeng
 * @date 2020/12/1 2:27 下午
 **/
@RestController
@RequestMapping("/index")
@Slf4j
public class IndexController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Master
    @RequestMapping(value = "/shardingOrder" , method = {RequestMethod.GET , RequestMethod.POST})
    public String shardingOrder(@RequestParam(name = "id" , required = false) Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        log.info("order:{}", JSONObject.toJSONString(order));
        return "shardingOrder success";
    }

    @Slave
    @RequestMapping(value = "/testSlave" , method = {RequestMethod.GET , RequestMethod.POST})
    public String testSlave(@RequestParam(name = "id" , required = false) Long id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        log.info("goods:{}", JSONObject.toJSONString(goods));
        return "testSlave success";
    }

    @Master
    @RequestMapping(value = "/testInsertOrder" , method = {RequestMethod.GET , RequestMethod.POST})
    public String testInsertOrder() {
        long start = System.currentTimeMillis();
        int batch = 10000;
        int sum = 1000000;
        int cur = 0;
        while (cur <= sum){
            List<Order> orderList = new ArrayList<>();
            long batchStart = System.currentTimeMillis();
            for (int i = 0; i < batch; i++) {
                Order order = new Order();
                long accId = i % 10;
                order.setAccId(accId);
                long goodsId = i % 10;
                order.setGoodsId(goodsId);
                order.setPayAmount(1000000);
                order.setCreateTime(new Date());
                order.setUpdateTime(new Date());
                order.setPayStatus(0);
                orderList.add(order);
            }
            orderMapper.batchInsertOrder(orderList);
            cur += batch;
            log.info("====cur===: "+cur);
            long batchEnd = System.currentTimeMillis();
            log.info("====batch costTime===: " + (batchEnd - batchStart));

        }
        long end = System.currentTimeMillis();
        long time = end - start;
        log.info("====costtime===: " + time);
        return "insert success";
    }



}
