package com.github.mattcanovas.services;

import java.math.BigDecimal;

public interface ICheckoutService {
    public BigDecimal purchaseProduct(String productName, String customerId);
}
