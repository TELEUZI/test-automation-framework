package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInLink;

    @FindBy(xpath = "//form[@role='search']//input[@placeholder='Search GitHub']")
    private WebElement searchInput;

    @FindBy(xpath = "//img[contains(@alt, '@TELEUZI')]")
    private WebElement username;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginPage() {
        this.signInLink.click();
    }

    public void enterSearch(String searchString) {
        this.searchInput.sendKeys(searchString);
    }

    public void submitSearch() {
        this.searchInput.submit();
    }

    public String getUsername() {
        return this.username.getAttribute("alt");
    }
}
