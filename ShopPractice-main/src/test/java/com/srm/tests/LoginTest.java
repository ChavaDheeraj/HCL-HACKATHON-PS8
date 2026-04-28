package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.pages.DashboardPage;
import com.srm.utils.ExcelUtil;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        String email = ExcelUtil.getEmail();

        LoginPage lp = new LoginPage(driver);
        lp.login(email, "Test@123");

        DashboardPage dp = new DashboardPage(driver);

        Assert.assertTrue(dp.isDashboardLoaded(), "Valid login failed");

        System.out.println("Login success with: " + email);
    }

    @Test
    public void invalidLoginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("wrong@gmail.com", "wrong123");

        Assert.assertTrue(lp.isErrorDisplayed());

        System.out.println("Invalid login validation passed");
    }
}