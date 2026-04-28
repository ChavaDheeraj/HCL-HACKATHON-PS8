package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.srm.base.BasePage;

public class CheckoutPage extends BasePage {

    By cartBtn = By.cssSelector("button[routerlink='/dashboard/cart']");
    By checkoutBtn = By.cssSelector(".totalRow button");
    By countryInput = By.cssSelector("[placeholder='Select Country']");
    By countryOption = By.xpath("//button[contains(@class,'ta-item')][2]");
    By placeOrderBtn = By.cssSelector(".action__submit");
    By successMsg = By.cssSelector(".hero-primary");
    By loader = By.cssSelector(".ngx-spinner-overlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        waitForLoaderToDisappear();
        waitClickable(cartBtn).click();
    }

    public void clickCheckout() {
        waitForLoaderToDisappear();
        waitClickable(checkoutBtn).click();
    }


    	public void selectCountry(String country) {
    	    waitForLoaderToDisappear();
    	    WebElement input = waitVisible(countryInput);
    	    input.clear();
    	    input.sendKeys(country);

    	    wait.until(ExpectedConditions.visibilityOfElementLocated(countryOption));
    	    driver.findElement(countryOption).click();
    	}

    	public void placeOrder() {
    	    waitForLoaderToDisappear();
    	    waitClickable(placeOrderBtn).click();
    	}

    	public String getSuccessMessage() {
    	    waitForLoaderToDisappear();
    	    return waitVisible(successMsg).getText();
    	}

    public void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }
}