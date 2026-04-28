package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import com.srm.base.BasePage;

public class OrdersPage extends BasePage {

    By ordersLink = By.cssSelector("[routerlink='/dashboard/myorders']");
    By orders = By.cssSelector("tbody tr");
    By loader = By.cssSelector(".ngx-spinner-overlay");

    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    public void openOrders() {
        waitForLoaderToDisappear();
        waitClickable(ordersLink).click();
    }

    public int getOrdersCount() {
        waitForLoaderToDisappear();
        List<WebElement> list = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(orders));
        return list.size();
    }

    public void waitForLoaderToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }
}