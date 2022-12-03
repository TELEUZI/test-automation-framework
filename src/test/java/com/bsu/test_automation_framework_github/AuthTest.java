package com.bsu.test_automation_framework_github;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthTest extends BaseTest {
    private static String validLogin;
    private static String validPassword;
    private static String validName;
    private final String ERROR_MESSAGE = "Incorrect username or password.";
    private LoginStep loginStep;

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
        loginStep = new LoginStep(driver);
    }

    @Test
    public void emptyLogin() {
        mainPage.navigateToLoginPage();
        loginStep.fillLoginForm("", Util.generateRandomName());
        assertEquals(loginStep.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void emptyPassword() {
        mainPage.navigateToLoginPage();
        loginStep.fillLoginForm(Util.generateRandomNameOfLength(6), "");
        assertEquals(loginStep.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void wrongDataLogin() {
        mainPage.navigateToLoginPage();
        loginStep.fillLoginForm(Util.generateRandomNameOfLength(8), Util.generateRandomNameOfLength(8));
        assertEquals(loginStep.getErrorText(), ERROR_MESSAGE);
    }

    @Test
    public void validDataLogin() {
        mainPage.navigateToLoginPage();
        loginStep.fillLoginForm(validLogin, validPassword);
        assertEquals("@".concat(validName), mainPage.getUsername());
    }
}
