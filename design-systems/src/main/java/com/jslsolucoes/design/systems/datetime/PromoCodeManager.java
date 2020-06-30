package com.jslsolucoes.design.systems.datetime;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

public class PromoCodeManager {

    private List<PromoCode> promoCodes = Lists.newArrayList();
  

    public PromoCode createNewPromoCode(String code, BigDecimal off) {
	PromoCode promoCode = new PromoCode(code, LocalDate.now().plusDays(3), off);
	promoCodes.add(promoCode);
	return promoCode;
    }

    public PromoCode applyPromoCode(String code) throws PromoCodeManagerException {
	PromoCode promoCode = findFor(code)
		.orElseThrow(() -> new PromoCodeManagerException("Cant find any promo code with value " + code));
	if (promoCode.getExpires().isBefore(LocalDate.now())) {
	    throw new PromoCodeManagerException("You have an expired promo code.");
	}
	return promoCode;
    }

    private Optional<PromoCode> findFor(String code) {
	return promoCodes.stream().filter(promoCode -> code.equals(promoCode.getCode())).findAny();
    }
}
