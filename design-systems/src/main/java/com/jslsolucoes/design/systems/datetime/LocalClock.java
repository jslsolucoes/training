package com.jslsolucoes.design.systems.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalClock implements Clock {

    @Override
    public LocalTime time() {
	return dateTime().toLocalTime();
    }

    @Override
    public LocalDate date() {
	return dateTime().toLocalDate();
    }

    @Override
    public LocalDateTime dateTime() {
	return LocalDateTime.now();
    }

    @Override
    public LocalDateTime startOfDay() {
	return dateTime().toLocalDate().atStartOfDay();
    }

    @Override
    public LocalDateTime endOfDay() {
	return dateTime().toLocalDate().atTime(LocalTime.MAX);
    }

}
