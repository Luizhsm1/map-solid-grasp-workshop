package com.monitoring.sales;

public class PixPayment implements PaymentMethod {

    @Override
    public void processPayment() {
        System.out.println("Processing PIX payment...");
    }
    
}
