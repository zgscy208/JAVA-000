package com.camp.activemq.order;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class OrderConsumer {
    @JmsListener(destination = "test.queue")
    public void receive(String msg) {
        System.out.println("监听到的消息内容为: " + msg);
    }
}
