package com.camp.activemq.api;

import javax.jms.Destination;

public interface Publisher<T> {
    void publish(T t);
}
