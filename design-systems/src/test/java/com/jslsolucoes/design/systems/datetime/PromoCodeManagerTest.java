package com.jslsolucoes.design.systems.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PromoCodeManagerTest {

    
    private PromoCodeManager promoCodeManager;
    
    @BeforeEach
    public void beforeEach() {
	promoCodeManager = new PromoCodeManager();
    }
    
    @Test
    public void isValidPromoCode() throws PromoCodeManagerException {
	promoCodeManager.createNewPromoCode("code1", BigDecimal.TEN);
    }
    
    @Test
    public void isInvalidPromoCode() throws PromoCodeManagerException {
	promoCodeManager.createNewPromoCode("code1", BigDecimal.TEN);
	PromoCodeManagerException promoCodeManagerException = 
		Assertions.assertThrows(PromoCodeManagerException.class, () ->{
	    promoCodeManager.applyPromoCode("code1");
	});
	assertEquals("You have an expired promo code.",promoCodeManagerException.getMessage());
    }
}
