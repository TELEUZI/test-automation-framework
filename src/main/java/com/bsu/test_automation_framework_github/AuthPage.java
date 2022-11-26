package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    @FindBy(xpath = "//*[@id='login_field']")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login\"]/div[4]/form/div/input[11]")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"js-flash-container\"]/div/div/div")
    public WebElement error;

    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        this.usernameInput.sendKeys(user);
    }

    public void enterPassword(String pass) {
        this.passwordInput.sendKeys(pass);
    }

    public void clickLogin() {
        this.submitButton.click();
    }
}
