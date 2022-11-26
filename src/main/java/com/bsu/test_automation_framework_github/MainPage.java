package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div/div/div[2]/a")
    public WebElement signInLink;

    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div/div/div[1]/div/div/form/label/input[1]")
    public WebElement searchInput;

    @FindBy(xpath = "/html/body/div[5]/div/aside/div/div/details/summary/span[1]")
    public WebElement username;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterSearch(String searchString) {
        this.searchInput.sendKeys(searchString);
    }
}
