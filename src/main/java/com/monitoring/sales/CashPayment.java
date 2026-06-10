package com.monitoring.sales;

public class CashPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing CASH payment...");
    }
    
}

