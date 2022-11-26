package com.bsu.test_automation_framework_github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BasePageTest {
    private static String validLogin;
    private static String validPassword;
    private static String validName;
    private final String ERROR_MESSAGE = "Incorrect username or password.";
    private AuthPage authPage;

    @BeforeAll
    public static void readProperties() {
        Properties properties = Util.readProperties();
        if (properties != null) {
            validLogin = properties.getProperty("email");
            validPassword = properties.getProperty("password");
            validName = properties.getProperty("username");
        }
    }

    @BeforeEach
    public void setUp() {
        super.setUp();
        authPage = new AuthPage(driver);
    }

    @Test
    public void emptyLogin() {
        mainPage.navigateToLoginPage();
        authPage.enterPassword("fgffff");
        authPage.clickLogin();
        assertEquals(authPage.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void emptyPassword() {
        mainPage.navigateToLoginPage();
        authPage.enterUsername("aaaaa");
        authPage.clickLogin();
        assertEquals(authPage.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void wrongDataLogin() {
        mainPage.navigateToLoginPage();
        authPage.enterUsername("aaaaa");
        authPage.enterPassword("fgffff");
        authPage.clickLogin();
        assertEquals(authPage.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void validDataLogin() {
        mainPage.navigateToLoginPage();
        authPage.enterUsername(validLogin);
        authPage.enterPassword(validPassword);
        authPage.clickLogin();
        assertEquals("@".concat(validName), mainPage.getUsername());
    }
}
