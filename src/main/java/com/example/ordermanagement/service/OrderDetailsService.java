package com.example.ordermanagement.service;

import com.example.ordermanagement.exception.NotFoundException;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.OrderDetails;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.model.QuantityRequest;
import com.example.ordermanagement.repository.OrderDetailsRepository;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.Integer.parseInt;

@Service
public class OrderDetailsService {
    private OrderDetailsRepository orderDetailsRepository;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setOrderDetailsRepository(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails  addOrderDetails(Long orderId, Long productId , QuantityRequest quantity){
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isEmpty()){
            throw new NotFoundException("Order not found");
        }else{
            Optional<Product> product = productRepository.findById(productId);
            if(product.isEmpty()){
                throw new NotFoundException("Product not found");
            }
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrder(order.get());
            orderDetails.setProduct(product.get());
            orderDetails.setQuantity(quantity.getQuantity());
            return orderDetailsRepository.save(orderDetails);
        }
    }

    public OrderDetails getOrderDetails(Long id){
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(id);
        if(orderDetails.isEmpty()){
            throw new NotFoundException("Order details not found");
        }
        return orderDetails.get();
    }
}
