package com.tperuch.kafka.producer;

import com.tperuch.commons.entity.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GatewayServiceProducer {

    private static final String TOPIC = "order-topic";
    private static final Logger log = LoggerFactory.getLogger(GatewayServiceProducer.class);

    @Autowired
    private KafkaTemplate<String, OrderEntity> kafkaTemplate;

    public void sendOrder(OrderEntity order) {
        CompletableFuture<SendResult<String, OrderEntity>> messageFeedback = kafkaTemplate.send(TOPIC, order.getId(), order);
        messageFeedback.whenComplete((stringOrderEntitySendResult, throwable) -> {
            if(throwable != null){
                log.error("Erro ao enviar pedido para o tópico {}: {} - ERRO: ", TOPIC, order, throwable);
            }else{
                log.info("Pedido enviado com sucesso ao tópico {} / PEDIDO: {} ", TOPIC, order);
            }
        });
    }
}
