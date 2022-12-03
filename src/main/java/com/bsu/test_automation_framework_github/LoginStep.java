package com.bsu.test_automation_framework_github;

import org.openqa.selenium.WebDriver;

public class LoginStep extends AuthPage {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String userName, String password) {
        enterUsername(userName);
        enterPassword(password);
        clickLogin();
    }
}
