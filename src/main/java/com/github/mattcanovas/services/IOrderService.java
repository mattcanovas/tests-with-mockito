package com.github.mattcanovas.services;

import com.github.mattcanovas.entity.Order;

public interface IOrderService {
    public Order createOrder(String productName, Long amount, String orderId);
}
