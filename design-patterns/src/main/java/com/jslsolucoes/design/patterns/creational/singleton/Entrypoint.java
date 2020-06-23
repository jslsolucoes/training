package com.jslsolucoes.design.patterns.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;

public class Entrypoint {

    public static void main(String[] args) throws SQLException {
	
	//Thread 1
	DatabaseImpl database = DatabaseImpl.instance();
	Connection connection = database.connection();
	
	
	//Thread 2
	DatabaseImpl database2 = DatabaseImpl.instance();
	Connection connection2 = database.connection();
	
	System.out.println("Db1 => " + database);
	System.out.println("Db2 => " + database2);
	System.out.println("Instance equals => " +  (database == database2));
	
    }
}
