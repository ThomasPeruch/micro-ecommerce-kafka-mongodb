package com.tperuch.kafka.consumer;

import com.tperuch.commons.entity.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessorConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderProcessorConsumer.class);
    @KafkaListener(topics = "order-topic", groupId = "order-processor-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderEntity order) {
        log.info("Pedido recebido no processor: {} - TÓPICO: order-topic", order);
    }
}

