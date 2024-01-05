package com.bsu.test_automation_framework_github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        searchPage = new SearchPage(driver);
    }

    @Test
    public void validUserSearch() {
        String validSearch = "TELEUZI";
        mainPage.enterSearch(validSearch);
        mainPage.submitSearch();
        searchPage.goToUsersTab();
        assertEquals(searchPage.getFirstUsername(), validSearch);
    }

    @Test
    public void invalidUserSearch() {
        String invalidSearch = "%TELEUZI$1";
        mainPage.enterSearch(invalidSearch);
        mainPage.submitSearch();
        searchPage.goToUsersTab();
        assertTrue(searchPage.getIsUserNotFound());
    }
}
