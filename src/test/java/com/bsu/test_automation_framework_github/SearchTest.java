package com.bsu.test_automation_framework_github;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    private final String URL = "https://github.com/";
    private final String VALID_SEARCH = "TELEUZI";
    private final String INVALID_SEARCH = "%TELEUZI$1";

    private WebDriver driver;
    private MainPage mainPage;
    private SearchPage searchPage;

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
        searchPage = new SearchPage(driver);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void validUserSearch() {
        mainPage.enterSearch(VALID_SEARCH);
        mainPage.submitSearch();

        searchPage.goToUsersTab();

        assertEquals(searchPage.getFirstUsername(), VALID_SEARCH);
    }

    @Test
    public void invalidUserSearch() {
        mainPage.enterSearch(INVALID_SEARCH);
        mainPage.submitSearch();

        searchPage.goToUsersTab();

        assertTrue(searchPage.getIsUserNotFound());
    }

}
