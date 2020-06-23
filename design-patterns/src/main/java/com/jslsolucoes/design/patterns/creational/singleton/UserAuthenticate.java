package com.jslsolucoes.design.patterns.creational.singleton;

import java.sql.Connection;
import java.sql.SQLException;

public class UserAuthenticate {


    public Boolean authenticate(String login, String password) throws SQLException {
	Database database =  DatabaseImpl.instance();
	Connection connection = database.connection();
	// test if user exists
	connection.close();
	return true;
    }
}
