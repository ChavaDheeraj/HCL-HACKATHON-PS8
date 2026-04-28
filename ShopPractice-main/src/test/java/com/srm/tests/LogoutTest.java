package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;
import com.srm.utils.ExcelUtil;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);
        Assert.assertTrue(dp.isDashboardLoaded(), "Login failed");

        dp.waitForLoaderToDisappear();   // ⭐ IMPORTANT

        dp.logout();

        Assert.assertTrue(lp.isLoginPage(), "Logout failed");

        System.out.println("Logout successful");
    }
}