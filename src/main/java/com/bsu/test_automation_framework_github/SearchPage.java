package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "/html/body/div[4]/main/div/div[2]/nav[1]/a[10]")
    private WebElement usersTab;

    @FindBy(xpath = "//*[@id='user_search_results']/div/div/div[2]/div[1]/div[1]/a[2]")
    private WebElement username;

    @FindBy(xpath = "/html/body/div[4]/main/div/div[3]/div/div/h3")
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
