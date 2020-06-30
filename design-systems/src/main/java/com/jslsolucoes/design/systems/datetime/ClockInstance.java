package com.jslsolucoes.design.systems.datetime;

public abstract class ClockInstance {

    public static Clock LOCAL = new LocalClock();
    public static Clock REMOTE = new RemoteClock();
   
}
