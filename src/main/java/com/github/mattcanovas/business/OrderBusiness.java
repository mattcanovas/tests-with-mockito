package com.github.mattcanovas.business;

import com.github.mattcanovas.entity.Order;
import com.github.mattcanovas.services.IOrderService;

public class OrderBusiness {
    
    private IOrderService service;

    public OrderBusiness(IOrderService service) {
        this.service = service;
    }

    public Order createOrder(String productName, Long amount, String uuid) {
        return this.service.createOrder(productName, amount, uuid);
    }

}
