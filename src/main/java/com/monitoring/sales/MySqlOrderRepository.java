package com.monitoring.sales;

public class MySqlOrderRepository implements OrderRepository {
    
    @Override
    public void saveOrder(Order order) {
        System.out.println("Connecting to MySQL...");
        System.out.println("Saving order...");
    }
    
}
