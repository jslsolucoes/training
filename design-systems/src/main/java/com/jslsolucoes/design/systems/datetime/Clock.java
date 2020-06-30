package com.jslsolucoes.design.systems.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public interface Clock {

    public LocalTime time();
    
    public LocalDate date();
    
    public LocalDateTime dateTime();
    
    public LocalDateTime startOfDay();
    
    public LocalDateTime endOfDay();
    
}
