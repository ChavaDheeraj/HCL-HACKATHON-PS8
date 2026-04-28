package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By email = By.id("userEmail");
    By password = By.id("userPassword");
    By loginBtn = By.id("login");

    By errorMsg = By.cssSelector(".toast-message");

    public void login(String user, String pass) {
        waitForElement(email).clear();
        driver.findElement(email).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return waitForElement(errorMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isLoginPage() {
        try {
            return waitForElement(By.id("login")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}