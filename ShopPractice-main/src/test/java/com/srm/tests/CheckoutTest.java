package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import com.srm.utils.ExcelUtil;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardLoaded(), "Login failed");

        dp.waitForLoaderToDisappear();

        dp.addFirstProduct();
        dp.waitForToast();

        CheckoutPage cp = new CheckoutPage(driver);

        cp.openCart();
        cp.clickCheckout();

        cp.selectCountry("India");
        cp.placeOrder();

        String msg = cp.getSuccessMessage();

        Assert.assertTrue(msg.toLowerCase().contains("thankyou"));

        System.out.println("Checkout successful");
    }
}