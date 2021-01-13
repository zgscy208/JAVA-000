package io.kimmking.javacourse.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class BeanConfig {
    private static final Logger logger = LogManager.getLogger(BeanConfig.class);

    @KafkaListener(id = "java1-kimmking", topics = "test32")
    public void listen(Order order) {
        logger.info("Received: {}", order);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("test32", 3, (short) 2);
    }
}
