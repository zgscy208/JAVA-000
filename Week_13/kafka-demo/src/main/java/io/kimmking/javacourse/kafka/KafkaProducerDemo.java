package io.kimmking.javacourse.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerDemo implements CommandLineRunner {
    private final String topic = "test32";
    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 1000; i++) {
            template.send(topic, new Order(1000L + i,System.currentTimeMillis(),"USD2CNY", 6.5d));
            template.send(topic, new Order(2000L + i,System.currentTimeMillis(),"USD2CNY", 6.51d));
        }
    }
}
