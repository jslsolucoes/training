package com.jslsolucoes.design.patterns.behavioral.observer;

public interface Subscriber<T> {

    public void onEvent(String eventType,T event);
    
}
