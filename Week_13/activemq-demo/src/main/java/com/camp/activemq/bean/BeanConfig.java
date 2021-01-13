package com.camp.activemq.bean;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class BeanConfig {
    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
    }

    @Bean
    public JmsTemplate jmsQueueTemplate(){
        return new JmsTemplate(connectionFactory());
    }
}
