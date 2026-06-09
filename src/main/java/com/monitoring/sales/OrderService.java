package com.monitoring.sales;

import java.util.List;

public class OrderService {

    public void processOrder(Order order, String paymentType) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        if (total > 500) {
            total = total - (total * 0.15);
        }

        System.out.println("Customer: " + order.getCustomerName());

        System.out.println("Items:");

        for (OrderItem item : order.getItems()) {
            System.out.println(
                    item.getProductName()
                            + " - "
                            + item.getQuantity()
                            + " x "
                            + item.getPrice());
        }

        System.out.println("Total: " + total);

        if (paymentType.equals("PIX")) {

            System.out.println("Processing PIX payment");

        } else if (paymentType.equals("CARD")) {

            System.out.println("Processing CARD payment");

        } else {

            throw new RuntimeException("Invalid payment method");

        }

        saveOrder(order);

        sendEmail(order);

    }

    private void saveOrder(Order order) {

        System.out.println("Connecting to MySQL...");

        System.out.println("Saving order...");

    }

    private void sendEmail(Order order) {

        System.out.println(
                "Sending confirmation email to "
                        + order.getCustomerName());

    }
}