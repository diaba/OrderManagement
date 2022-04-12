package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.OrderDetails;
import com.example.ordermanagement.model.QuantityRequest;
import com.example.ordermanagement.service.OrderDetailsService;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderController {
    private OrderService orderService;
    private OrderDetailsService orderDetailsService;

    @Autowired
    public void setOrderDetailsService(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable Long orderId){
        return  orderService.getOrder(orderId);
    }
    @PostMapping("/order/{orderId}/product/{productId}")
    public OrderDetails addOrderDetails(@PathVariable Long orderId,
                                        @PathVariable Long productId,
                                        @RequestBody QuantityRequest quantity){
        return orderDetailsService.addOrderDetails(orderId,productId,quantity);
    }
}
