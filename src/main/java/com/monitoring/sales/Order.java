package com.monitoring.sales;

import java.util.List;

public class Order {

    private String customerName;
    private List<OrderItem> items;

    public Order(String customerName, List<OrderItem> items) {
        this.customerName = customerName;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}