package com.jslsolucoes.design.patterns.behavioral.observer;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;

public class Publisher<T> {

    private SetMultimap<String, Subscriber<T>> subscribers = HashMultimap.create();

    protected void subscribe(String eventType, Subscriber<T> subscriber) {
	subscribers.put(eventType, subscriber);
    }

    protected void unsubscribe(String eventType, Subscriber<T> subscriber) {
	subscribers.remove(eventType, subscriber);
    }

    protected void publish(String eventType, T event) {
	for (Subscriber<T> subscriber : subscribers.get(eventType)) {
	    subscriber.onEvent(eventType, event);
	}
    }

}
