package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.srm.base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By cartBtn = By.cssSelector("button[routerlink='/dashboard/cart']");
    By items = By.cssSelector(".cartSection h3");
    By deleteBtn = By.cssSelector(".cartSection .btn-danger");
    By emptyMsg = By.xpath("//*[contains(text(),'No Products in Your Cart')]");

    public void openCart() {

        WebElement cart = waitClickable(cartBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", cart);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", cart);

        waitForElement(items);
    }

    public int getItems() {
        return driver.findElements(items).size();
    }

    public void deleteFirstItem() {
        if (driver.findElements(deleteBtn).size() > 0) {
            driver.findElements(deleteBtn).get(0).click();
        }
    }

    public void waitForCartToReduce(int oldCount) {
        wait.until(driver -> driver.findElements(items).size() < oldCount);
    }

    public boolean isCartEmpty() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}