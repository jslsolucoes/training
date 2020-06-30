package com.jslsolucoes.design.systems.datetime;

import java.math.BigDecimal;

public class Entrypoint {

    public static void main(String[] args) throws PromoCodeManagerException {
	PromoCodeManager promoCodeManager = new PromoCodeManager();
	PromoCode createdPromoCode = promoCodeManager.createNewPromoCode("JSL1", BigDecimal.TEN);
	try {
	    PromoCode promoCode = promoCodeManager.applyPromoCode(createdPromoCode.getCode());
	    System.out.println("You have a valid promo code. Applying " + promoCode.getOff() + "% off");
	} catch (PromoCodeManagerException promoCodeManagerException) {
	    System.out.println(promoCodeManagerException.getMessage());
	    throw promoCodeManagerException;
	}
    }
}
