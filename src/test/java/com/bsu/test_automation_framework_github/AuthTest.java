package com.bsu.test_automation_framework_github;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTest {
    private static String validLogin;
    private static String validPassword;
    private static String validName;
    private WebDriver driver;
    private MainPage mainPage;
    private AuthPage authPage;

    private final String URL = "https://github.com/";
    private final String ERROR_MESSAGE = "Incorrect username or password.";

    @BeforeAll
    public static void readProperties() {
        try (InputStream input = AuthTest.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);

            validLogin = prop.getProperty("email");
            validPassword = prop.getProperty("password");
            validName = prop.getProperty("username");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);

        driver.get(URL);

        mainPage = new MainPage(driver);
        authPage = new AuthPage(driver);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    

    @Test
    public void emptyLogin() {
        mainPage.navigateToLoginPage();

        authPage.enterPassword("fgffff");
        authPage.clickLogin();


        assertEquals(authPage.getErrorText(), (ERROR_MESSAGE));
    }

    @Test
    public void emptyPassword() {
        mainPage.navigateToLoginPage();

        authPage.enterUsername("aaaaa");
        authPage.clickLogin();


        assertEquals(authPage.getErrorText(), (ERROR_MESSAGE));
    }

    @Test
    public void wrongDataLogin() {
        mainPage.navigateToLoginPage();

        authPage.enterUsername("aaaaa");
        authPage.enterPassword("fgffff");
        authPage.clickLogin();


        assertEquals(authPage.getErrorText(), (ERROR_MESSAGE));
    }

    @Test
    public void validDataLogin() {
        mainPage.navigateToLoginPage();

        authPage.enterUsername(validLogin);
        authPage.enterPassword(validPassword);
        authPage.clickLogin();


        assertEquals(validName, mainPage.getUsername());
    }


}
