package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.OrderDetails;
import com.example.ordermanagement.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderDetailsController {
    private OrderDetailsService orderDetailsService;

    @Autowired
    public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/orderdetails/{orderId}")
    public OrderDetails getOrderDetails(@PathVariable Long orderId){
        return orderDetailsService.getOrderDetails(orderId);
    }

}
