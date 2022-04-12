package com.example.ordermanagement.service;

import com.example.ordermanagement.exception.NotFoundException;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getOrder(Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()){
            throw new NotFoundException("Order not found");
        }
        return order.get();

    }

}
