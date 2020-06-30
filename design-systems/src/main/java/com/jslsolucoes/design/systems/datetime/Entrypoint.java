package com.jslsolucoes.design.systems.datetime;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Entrypoint {

    public static void main(String[] args) throws PromoCodeManagerException {	
	Clock clock = ClockInstance.REMOTE;
	PromoCodeManager promoCodeManager = new PromoCodeManager(clock);
	PromoCode createdPromoCode = promoCodeManager.createNewPromoCode("JSL1", BigDecimal.TEN);
	try {
	    PromoCode promoCode = promoCodeManager.applyPromoCode(createdPromoCode.getCode());
	    System.out.println("You have a valid promo code. Applying " + promoCode.getOff() + "% off" + ",  expires " + promoCode.getExpires().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
	} catch (PromoCodeManagerException promoCodeManagerException) {
	    System.out.println(promoCodeManagerException.getMessage());
	    throw promoCodeManagerException;
	}
    }
}
