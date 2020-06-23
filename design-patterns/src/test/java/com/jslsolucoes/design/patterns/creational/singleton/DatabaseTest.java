package com.jslsolucoes.design.patterns.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class DatabaseTest {

    @Test
    public void assertInstanceEquals() {
	DatabaseImpl database = DatabaseImpl.instance();
	DatabaseImpl database2 = DatabaseImpl.instance();
	assertEquals(database, database2);
    }
    
    @Test
    public void createConnection() {
	DatabaseImpl database = DatabaseImpl.instance();
	Connection connection = database.connection();
	Connection connection2 = database.connection();
	assertNotEquals(connection, connection2);
    }
    
    
}
