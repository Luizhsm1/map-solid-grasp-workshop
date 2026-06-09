package com.monitoring.sales;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        OrderItem notebook = new OrderItem(
                "Notebook",
                3500,
                1);

        OrderItem mouse = new OrderItem(
                "Mouse",
                100,
                2);

        Order order = new Order(
                "John Doe",
                List.of(notebook, mouse));

        OrderService orderService = new OrderService();

        orderService.processOrder(order, "PIX");
    }
}