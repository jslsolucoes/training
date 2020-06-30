package com.jslsolucoes.design.systems.datetime;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

public class PromoCodeManager {

    private List<PromoCode> promoCodes = Lists.newArrayList();
    private Clock clock;
  
    
    public PromoCodeManager(Clock clock) {
	this.clock = clock;
    }

    public PromoCode createNewPromoCode(String code, BigDecimal off) {
	PromoCode promoCode = new PromoCode(code, localDate().plusDays(3), off);
	promoCodes.add(promoCode);
	return promoCode;
    }

    public PromoCode applyPromoCode(String code) throws PromoCodeManagerException {
	PromoCode promoCode = findPromoCodeByCode(code)
		.orElseThrow(() -> new PromoCodeManagerException("Cant find any promo code with value " + code));
	if (promoCode.getExpires().isBefore(localDate())) {
	    throw new PromoCodeManagerException("You have an expired promo code.");
	}
	return promoCode;
    }
    
    private LocalDate localDate() {
	return clock.date();
    }

    private Optional<PromoCode> findPromoCodeByCode(String code) {
	return promoCodes.stream().filter(promoCode -> code.equals(promoCode.getCode())).findAny();
    }
}
