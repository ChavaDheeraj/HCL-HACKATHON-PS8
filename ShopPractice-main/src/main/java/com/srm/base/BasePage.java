package com.srm.base;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

	    public WebElement waitClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
	    
	    public WebElement waitVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }
	    public void waitForLoaderToDisappear() {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(
	                By.cssSelector(".ngx-spinner-overlay")));
	    }
}