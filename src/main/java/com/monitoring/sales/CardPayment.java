package com.monitoring.sales;

public class CardPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing CARD payment...");
    }
    
}
