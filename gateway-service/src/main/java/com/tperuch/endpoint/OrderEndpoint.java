package com.tperuch.endpoint;

import com.tperuch.commons.dto.OrderDTO;
import com.tperuch.commons.entity.OrderEntity;
import com.tperuch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderEntity order(@RequestBody OrderDTO orderDTO){
        return orderService.saveOrder(orderDTO);
    }
}
