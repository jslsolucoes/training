package com.jslsolucoes.design.patterns.behavioral.observer;

public class NotifyQueue implements Subscriber<Order> {

    @Override
    public void onEvent(String eventType, Order order) {
	System.out.println("Sending order to queue , " + eventType + " => " + order.getCustomerEmail() + ":" + order.getCustomerName());
    }

}
