package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.RegisterPage;
import com.srm.utils.ExcelUtil;

public class RegisterTest extends BaseTest {

    @Test
    public void newUserRegistrationTest() {

        RegisterPage rp = new RegisterPage(driver);
        rp.openRegister();

        String email = "user" + System.currentTimeMillis() + "@gmail.com";

        rp.fillForm("Test", "User", email, "9876543210", "Test@123");
        rp.clickRegister();

        Assert.assertTrue(rp.isRegistrationSuccess(), "Registration failed");

        ExcelUtil.writeEmail(email);

        System.out.println("Registered & saved: " + email);
    }
}