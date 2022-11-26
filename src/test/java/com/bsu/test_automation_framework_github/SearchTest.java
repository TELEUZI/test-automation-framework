package com.bsu.test_automation_framework_github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BasePageTest {
    private final String VALID_SEARCH = "TELEUZI";
    private final String INVALID_SEARCH = "%TELEUZI$1";

    private SearchPage searchPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        searchPage = new SearchPage(driver);
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
