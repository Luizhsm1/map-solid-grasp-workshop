package com.monitoring.sales;

public class DiscountService {
    public double applyDiscount(double total) {

        if (total > 1000) {
            total = total - (total * 0.05);
        }

        if (total > 500) {
            total = total - (total * 0.15);
        }

        return total;
    }
}