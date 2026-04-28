package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    By products = By.cssSelector(".card-body");
    By addToCartBtns = By.cssSelector(".card-body button:last-of-type");
    By dashboardText = By.xpath("//*[contains(text(),'Showing')]");
    By logoutBtn = By.xpath("//button[normalize-space()='Sign Out']");
    By cartCount = By.cssSelector("button[routerlink='/dashboard/cart'] label");
    By toastMsg = By.cssSelector("#toast-container");
    By loader = By.cssSelector(".ngx-spinner-overlay");

    public boolean isDashboardLoaded() {
        try {
            return waitForElement(dashboardText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addFirstProduct() {

        waitForLoaderToDisappear();

        By products = By.cssSelector(".mb-3");
        By addToCart = By.cssSelector(".card-body button:last-of-type");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));

        WebElement firstProduct = driver.findElements(products).get(0);

        WebElement button = firstProduct.findElement(addToCart);

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
    
    
    public int getCartCount() {
        try {
            return Integer.parseInt(waitForElement(cartCount).getText());
        } catch (Exception e) {
            return 0;
        }
    }
    

public int getProductCount() {
    waitForElement(products);
    return driver.findElements(products).size();
}

public void logout() {
    waitClickable(logoutBtn).click();
}

    public void waitForToast() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastMsg));
    }

    public void waitForCartUpdate(int oldCount) {
        wait.until(driver -> {
            try {
                int newCount = Integer.parseInt(driver.findElement(cartCount).getText());
                return newCount > oldCount;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }
}