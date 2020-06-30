package com.jslsolucoes.design.systems.datetime;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromoCode {

    private final LocalDate expires;
    private final String code;
    private final BigDecimal off;

    public PromoCode(final String code, final LocalDate expires,final BigDecimal off) {
	this.code = code;
	this.expires = expires;
	this.off = off;
    }

    public LocalDate getExpires() {
	return expires;
    }

    public String getCode() {
	return code;
    }

    public BigDecimal getOff() {
	return off;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	PromoCode other = (PromoCode) obj;
	if (code == null) {
	    if (other.code != null)
		return false;
	} else if (!code.equals(other.code))
	    return false;
	return true;
    }

}
