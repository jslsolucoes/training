package com.jslsolucoes.design.patterns.behavioral.observer;

public class NotifyViaSms implements Subscriber<Order> {

    @Override
    public void onEvent(String eventType, Order order) {
	System.out.println(
		"Sending sms, " + eventType + " => " + order.getCustomerEmail() + ":" + order.getCustomerName());
    }

}
