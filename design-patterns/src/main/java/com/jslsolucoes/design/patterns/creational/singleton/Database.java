package com.jslsolucoes.design.patterns.creational.singleton;

import java.sql.Connection;

public interface Database extends AutoCloseable {

    public Connection connection();
    
}
