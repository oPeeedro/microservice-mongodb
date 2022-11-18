package com.microservice.orderservice.service;

import com.microservice.orderservice.model.Order;
import com.microservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){this.orderRepository = orderRepository;}

    public void createOrder(Order order) {
        order.setOrderTime(System.currentTimeMillis());
        order.setTotalPrice(order.getMenuItemList().stream().mapToInt(e -> e.getPrice() * e.getQuantity()).sum());
        orderRepository.save(order);
    }
}
