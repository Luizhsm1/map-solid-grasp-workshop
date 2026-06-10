package com.monitoring.sales;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderServiceTest {
    
    @Test
    void shouldSaveOrderAndSendConfirmationWhenOrderIsProcessed() {
        DiscountService discountService = new DiscountService();
        PaymentService paymentService = new PaymentService();

        OrderRepository repository = mock(OrderRepository.class);
        NotificationService notificationService = mock(NotificationService.class);

        OrderService orderService = new OrderService(
                discountService,
                paymentService,
                repository,
                notificationService
        );

        Order order = new Order(
                "John Doe",
                List.of(
                        new OrderItem("Keyboard", 100, 2),
                        new OrderItem("Mouse", 50, 1)
                )
        );

        PaymentMethod paymentMethod = new PixPayment();

        orderService.processOrder(order, paymentMethod);

        verify(repository).saveOrder(order);
        verify(notificationService).sendConfirmation(order);
    }
}