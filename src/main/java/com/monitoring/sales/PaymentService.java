package com.monitoring.sales;

public class PaymentService {
    public void processPayment(String paymentType) {

        if (paymentType.equals("PIX")) {

            System.out.println("Processing PIX payment");

        } else if (paymentType.equals("CARD")) {

            System.out.println("Processing CARD payment");

        } else if (paymentType.equals("CASH")) {

            System.out.println("Processing CASH payment");

        } else {

            throw new RuntimeException("Invalid payment method");

        }
    }
}
