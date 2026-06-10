package com.monitoring.sales;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    
    @Test
    void shouldCalculateTotalWhenOrderHasMultipleItems() {

        Order order = new Order(
                "John Doe",
                List.of(
                        new OrderItem("Keyboard", 100, 2),
                        new OrderItem("Mouse", 50, 1)
                )
        );

        double total = order.calculateTotal();

        assertEquals(250, total);
    }
}
