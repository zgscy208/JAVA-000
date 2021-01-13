package com.camp.activemq.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class OrderPublisher {

    @Autowired
    private JmsTemplate jmsTemplate;
    private AtomicInteger counter = new AtomicInteger(0);

    public void publish(Order order) {
        jmsTemplate.send("test.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(counter.getAndIncrement() + " message sent: " + order);
            }
        });
    }
}
