package com.github.mattcanovas.processors;

import java.math.BigDecimal;

public class PaymentProcessor {
    private Boolean allowForeignCurrencies;
    private String fallbackOption;
    private BigDecimal taxRate;

    public PaymentProcessor() {
        this(false, "DEBIT", new BigDecimal("19.00"));
    }

    public PaymentProcessor(String fallbackOption, BigDecimal taxRate) {
        this(false, fallbackOption, taxRate);
    }

    public PaymentProcessor(Boolean allowForeignCurrencies, String fallbackOption, BigDecimal taxRate) {
        this.allowForeignCurrencies = allowForeignCurrencies;
        this.fallbackOption = fallbackOption;
        this.taxRate = taxRate;
    }

    public BigDecimal chargerCustomer(String customerId, BigDecimal taxRate) {
        System.out.println("About to charge customer: " + customerId);
        return BigDecimal.ZERO;
    }

    public Boolean getAllowForeignCurrencies() {
        return allowForeignCurrencies;
    }

    public void setAllowForeignCurrencies(Boolean allowForeignCurrencies) {
        this.allowForeignCurrencies = allowForeignCurrencies;
    }

    public String getFallbackOption() {
        return fallbackOption;
    }

    public void setFallbackOption(String fallbackOption) {
        this.fallbackOption = fallbackOption;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

}
