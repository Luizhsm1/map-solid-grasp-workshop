package com.monitoring.sales;

import java.util.List;

public class OrderService {

    private final DiscountService discountService = new DiscountService();
    private final PaymentService paymentService = new PaymentService();
    private final OrderRepository repository = new OrderRepository();
    private final EmailService emailService = new EmailService();

    public void processOrder(Order order, String paymentType) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        total = discountService.applyDiscount(total);

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

        paymentService.processPayment(paymentType);

        repository.saveOrder(order);

        emailService.sendEmail(order);

    }

}