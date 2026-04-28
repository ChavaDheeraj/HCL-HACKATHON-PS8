package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import com.srm.utils.ExcelUtil;

public class ProductTest extends BaseTest {

    @Test
    public void productValidationTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);

        Assert.assertTrue(dp.isDashboardLoaded(), "Dashboard not loaded");

        dp.waitForLoaderToDisappear();   // ⭐ IMPORTANT FIX

        int count = dp.getProductCount();

        Assert.assertTrue(count > 0, "No products found");

        System.out.println("Products available: " + count);
    }
}