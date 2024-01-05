package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "//a[@class='menu-item'][contains(text(),\"Users\")]")
    private WebElement usersTab;

    @FindBy(xpath = "//*[@id='user_search_results']//a[2]")
    private WebElement username;

    @FindBy(xpath = "//div[contains(@class,'codesearch-results')]//h3")
    private WebElement userNotFoundError;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void goToUsersTab() {
        this.usersTab.click();
    }

    String getFirstUsername() {
        return this.username.getText();
    }

    boolean getIsUserNotFound() {
        return this.userNotFoundError.isDisplayed();
    }
}
