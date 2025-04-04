package com.tperuch.endpoint;

import com.tperuch.commons.dto.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping("/order")
public class OrderEndpoint {
    @PostMapping
    public String order(@RequestBody OrderDTO orderDTO){
        System.out.println(orderDTO);
        return "pedido recebido";
    }
}
