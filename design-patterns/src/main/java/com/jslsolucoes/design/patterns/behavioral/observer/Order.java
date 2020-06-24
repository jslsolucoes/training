package com.jslsolucoes.design.patterns.behavioral.observer;

public class Order {

    private final String customerName;
    private final String customerEmail;

    public Order(final String customerName, final String customerEmail) {
	this.customerName = customerName;
	this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
	return customerName;
    }

    public String getCustomerEmail() {
	return customerEmail;
    }

}
