package com.github.mattcanovas.services.implementations;

import java.math.BigDecimal;

import com.github.mattcanovas.processors.PaymentProcessor;
import com.github.mattcanovas.services.ICheckoutService;

public class CheckoutService implements ICheckoutService{

    @Override
    public BigDecimal purchaseProduct(String productName, String customerId) {
        PaymentProcessor processor = new PaymentProcessor();
        return processor.chargerCustomer(customerId, BigDecimal.TEN);
    }
    
}
