package com.jslsolucoes.design.systems.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PromoCodeManagerTest {

    private PromoCodeManager promoCodeManager;

    @Mock
    private Clock clock;

    @BeforeEach
    public void beforeEach() {
	promoCodeManager = new PromoCodeManager(clock);
    }

    @Test
    public void isValidPromoCode() throws PromoCodeManagerException {
	LocalDate now = LocalDate.now();
	Mockito.when(clock.date()).thenReturn(now);
	PromoCode promoCode = promoCodeManager.createNewPromoCode("code1", BigDecimal.TEN);
	assertEquals(now.plusDays(3), promoCode.getExpires());
    }

    @Test
    public void isInvalidPromoCode() throws PromoCodeManagerException {
	LocalDate now = LocalDate.now();
	Mockito.when(clock.date()).thenReturn(now, now.plusDays(4));
	promoCodeManager.createNewPromoCode("code1", BigDecimal.TEN);
	PromoCodeManagerException promoCodeManagerException = Assertions.assertThrows(PromoCodeManagerException.class,
		() -> {
		    promoCodeManager.applyPromoCode("code1");
		});
	assertEquals("You have an expired promo code.", promoCodeManagerException.getMessage());
    }
}
