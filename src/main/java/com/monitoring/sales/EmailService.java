package com.monitoring.sales;

public class EmailService implements NotificationService {
    
    @Override
    public void sendConfirmation(Order order) {
        System.out.println(
                "Sending confirmation email to "
                        + order.getCustomerName());
    }
    
}
