package com.monitoring.sales;

public class OrderService {

    private final DiscountService discountService = new DiscountService();
    private final PaymentService paymentService = new PaymentService();
    private final OrderRepository repository = new OrderRepository();
    private final EmailService emailService = new EmailService();

    public void processOrder(Order order, String paymentType) {
        double total = order.calculateTotal();

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

        PaymentMethod paymentMethod;

        if (paymentType.equals("PIX")) {
            paymentMethod = new PixPayment();
        } else if (paymentType.equals("CARD")) {
            paymentMethod = new CardPayment();
        } else if (paymentType.equals("CASH")) {
            paymentMethod = new CashPayment();
        } else {
            throw new RuntimeException("Invalid payment method");
        }

        paymentService.processPayment(paymentMethod);

        repository.saveOrder(order);

        emailService.sendEmail(order);

    }

}