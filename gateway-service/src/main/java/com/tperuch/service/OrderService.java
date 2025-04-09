package com.tperuch.service;

import com.tperuch.commons.dto.OrderDTO;
import com.tperuch.commons.entity.ItemEntity;
import com.tperuch.commons.entity.OrderEntity;
import com.tperuch.kafka.producer.GatewayServiceProducer;
import com.tperuch.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GatewayServiceProducer gatewayServiceProducer;

    public OrderEntity saveOrder(OrderDTO orderDTO){
        OrderEntity orderEntity = mapFromDtoToEntity(orderDTO);
        OrderEntity orderEntitySaved = orderRepository.insert(orderEntity);
        produceOrderEvent(orderEntitySaved);
        return orderEntitySaved;
    }

    private void produceOrderEvent(OrderEntity orderEntitySaved) {
        gatewayServiceProducer.sendOrder(orderEntitySaved);
    }

    private static OrderEntity mapFromDtoToEntity(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomerName(orderDTO.getCustomerName());
        orderEntity.setReceivedAt(LocalDateTime.now());
        List<ItemEntity> itemsEntity = orderDTO.getItems().stream().map(
                itemDTO -> new ItemEntity(
                            itemDTO.getProductName(),
                            itemDTO.getPrice(),
                            itemDTO.getQuantity()))
                .toList();
        orderEntity.setItems(itemsEntity);
        return orderEntity;
    }
}
