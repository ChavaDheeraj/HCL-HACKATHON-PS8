package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import com.srm.utils.ExcelUtil;

public class OrderTest extends BaseTest {

    @Test
    public void orderHistoryTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardLoaded(), "Login failed");

        dp.waitForLoaderToDisappear();

        dp.addFirstProduct();
        dp.waitForToast();
        dp.waitForLoaderToDisappear();

        CheckoutPage cp = new CheckoutPage(driver);

        cp.openCart();
        cp.waitForLoaderToDisappear();

        cp.clickCheckout();
        cp.waitForLoaderToDisappear();

        cp.selectCountry("India");
        cp.placeOrder();

        cp.waitForLoaderToDisappear();   // 🔥 IMPORTANT

        OrdersPage op = new OrdersPage(driver);

        op.openOrders();
        op.waitForLoaderToDisappear();   // 🔥 IMPORTANT

        int count = op.getOrdersCount();

        Assert.assertTrue(count > 0, "No orders found");

        System.out.println("Orders found: " + count);
    }
}