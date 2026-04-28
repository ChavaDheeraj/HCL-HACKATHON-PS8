package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import com.srm.utils.ExcelUtil;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardLoaded(), "Login failed");

        int before = dp.getCartCount();

        dp.addFirstProduct();
        dp.waitForToast();
        dp.waitForLoaderToDisappear();   // ⭐ FIX

        dp.waitForCartUpdate(before);

        int after = dp.getCartCount();

        Assert.assertTrue(after > before, "Cart count not increased");

        System.out.println("Add to cart passed");
    }

    @Test
    public void deleteFromCartTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardLoaded(), "Login failed");

        dp.addFirstProduct();
        dp.waitForToast();
        dp.waitForLoaderToDisappear();   // ⭐ FIX

        CartPage cp = new CartPage(driver);
        cp.openCart();

        int before = cp.getItems();

        cp.deleteFirstItem();
        cp.waitForCartToReduce(before);

        int after = cp.getItems();

        Assert.assertTrue(after < before || cp.isCartEmpty(), "Item not deleted");

        System.out.println("Delete from cart passed");
    }
}