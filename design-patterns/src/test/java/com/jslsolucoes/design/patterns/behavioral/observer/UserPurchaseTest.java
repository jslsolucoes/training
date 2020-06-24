package com.jslsolucoes.design.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserPurchaseTest {

    @Test
    public void createPurchaseOrder() {
	Subscriber<Order> subscriber1 = mock(Subscriber.class);
	Subscriber<Order> subscriber2 = mock(Subscriber.class);
	Order order = new Order("jj", "aa@aa.com");
	UserPurchase userPurchase = new UserPurchase(order);
	userPurchase.subscribe("create", subscriber1);
	userPurchase.subscribe("create", subscriber2);
	userPurchase.create();
	verify(subscriber1, times(1)).onEvent("create", order);
	verify(subscriber2, times(1)).onEvent("create", order);
    }
}
