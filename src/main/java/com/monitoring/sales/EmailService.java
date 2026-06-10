package com.monitoring.sales;

public class EmailService {
    public void sendEmail(Order order) {

        System.out.println(
                "Sending confirmation email to "
                        + order.getCustomerName());

    }
}
