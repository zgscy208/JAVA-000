package com.camp.activemq.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OrderMQRunner implements CommandLineRunner {
    @Autowired OrderPublisher orderPublisher;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            Order order = new Order(i, random.nextInt(100), random.nextInt(100), random.nextInt(100));
            orderPublisher.publish(order);
        }
    }
}
