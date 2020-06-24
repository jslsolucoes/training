package com.jslsolucoes.design.patterns.behavioral.observer;

public class UserPurchase {

    private final Order order;
    private final Publisher<Order> publisher = new Publisher<Order>();

    public UserPurchase(final Order order) {
	this.order = order;
    }

    public void create() {
	publisher.publish("create", order);
	System.out.println("Order created and subscribers notifieds");
    }

    public void subscribe(String eventType, Subscriber<Order> subscriber) {
	publisher.subscribe(eventType, subscriber);
    }

}
