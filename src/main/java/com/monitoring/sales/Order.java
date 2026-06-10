package com.monitoring.sales;

import java.util.List;

public class Order {

    private String customerName;
    private List<OrderItem> items;

    public Order(String customerName, List<OrderItem> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        
        return total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}