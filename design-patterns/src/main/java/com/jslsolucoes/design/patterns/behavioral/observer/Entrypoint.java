package com.jslsolucoes.design.patterns.behavioral.observer;

public class Entrypoint {

    public static void main(String[] args) {
	Order order = new Order("jonatan", "jonatan@jslsolucoes.com");
	UserPurchase userPurchase = new UserPurchase(order);
	userPurchase.subscribe("create", new NotifyQueue());
	userPurchase.subscribe("create", new NotifyCustomer());
	userPurchase.subscribe("create",new NotifyViaSms());
	userPurchase.create();
    }
}
