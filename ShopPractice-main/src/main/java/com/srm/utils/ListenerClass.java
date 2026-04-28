package com.srm.utils;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerClass implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver = null;

        try {
            // 🔥 get driver from test class dynamically
            Object currentClass = result.getInstance();
            Field field = currentClass.getClass().getSuperclass().getDeclaredField("driver");

            field.setAccessible(true);
            driver = (WebDriver) field.get(currentClass);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String path = ScreenshotUtil.capture(driver, result.getName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}