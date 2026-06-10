package com.monitoring.sales;

public class OrderService {

    private final DiscountService discountService;
    private final PaymentService paymentService;
    private final OrderRepository repository;
    private final NotificationService notificationService;

    public OrderService(
            DiscountService discountService,
            PaymentService paymentService,
            OrderRepository repository,
            NotificationService notificationService) {

        this.discountService = discountService;
        this.paymentService = paymentService;
        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void processOrder(Order order, PaymentMethod paymentMethod) {
        double total = order.calculateTotal();

        total = discountService.applyDiscount(total);

        System.out.println("Customer: " + order.getCustomerName());
        System.out.println("Total: " + total);

        paymentService.processPayment(paymentMethod);

        repository.saveOrder(order);

        notificationService.sendConfirmation(order);

    }

}