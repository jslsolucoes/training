package com.jslsolucoes.design.patterns.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class UserAuthenticateTest {

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    public void authentication() throws SQLException {
	UserAuthenticate userAuthenticate = new UserAuthenticate();
	assertTrue(userAuthenticate.authenticate("aa", "bb"));
    }

    @AfterEach
    public void afterEach() throws SQLException {

    }

}
