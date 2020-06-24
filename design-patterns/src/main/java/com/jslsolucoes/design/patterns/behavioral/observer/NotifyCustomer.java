package com.jslsolucoes.design.patterns.behavioral.observer;

public class NotifyCustomer implements Subscriber<Order> {

    @Override
    public void onEvent(String eventType, Order order) {
	System.out.println("Notifying customer, " + eventType + " => " + order.getCustomerEmail() + ":" + order.getCustomerName());
    }

}
