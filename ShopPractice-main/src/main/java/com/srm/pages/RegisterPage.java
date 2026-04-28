package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import com.srm.base.BasePage;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    By registerLink = By.linkText("Register");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By phone = By.id("userMobile");
    By password = By.id("userPassword");
    By confirmPassword = By.id("confirmPassword");
    By registerBtn = By.id("login");

    By occupation = By.cssSelector("select[formcontrolname='occupation']");
    By checkbox = By.cssSelector("input[type='checkbox']");

    By successMsg = By.xpath("//*[contains(text(),'Account Created Successfully')]");

    public void openRegister() {
        waitClickable(registerLink).click();
    }

    public void fillForm(String f, String l, String mail, String ph, String pass) {
        waitForElement(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(phone).sendKeys(ph);

        new Select(driver.findElement(occupation)).selectByVisibleText("Student");

        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);

        WebElement check = waitClickable(checkbox);
        if (!check.isSelected()) check.click();
    }

    public void clickRegister() {
        waitClickable(registerBtn).click();
    }

    public boolean isRegistrationSuccess() {
        try {
            return waitForElement(successMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}