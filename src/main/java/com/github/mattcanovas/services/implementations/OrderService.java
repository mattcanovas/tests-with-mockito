package com.github.mattcanovas.services.implementations;

import static java.util.Objects.isNull;

import java.time.LocalDateTime;
import java.util.UUID;

import com.github.mattcanovas.entity.Order;
import com.github.mattcanovas.services.IOrderService;

public class OrderService implements IOrderService {

    @Override
    public Order createOrder(String productName, Long amount, String orderId) {
        Order order = new Order();

        order.setId(isNull(orderId) ? UUID.randomUUID().toString() : orderId);
        order.setCreationDate(LocalDateTime.now());
        order.setAmount(amount);
        order.setProductName(productName);
        return order;
    }

}
