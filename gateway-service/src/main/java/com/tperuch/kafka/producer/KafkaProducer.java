package com.tperuch.kafka.producer;

import com.tperuch.commons.dto.OrderDTO;
import com.tperuch.commons.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "order-topic";

    @Autowired
    private KafkaTemplate<String, OrderEntity> kafkaTemplate;

    public void sendOrder(OrderEntity order) {
        kafkaTemplate.send(TOPIC, order.getId(), order);
    }
}
