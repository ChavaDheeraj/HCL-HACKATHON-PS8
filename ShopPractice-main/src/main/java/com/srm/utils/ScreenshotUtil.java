package com.srm.utils;

import org.openqa.selenium.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + "_" +
                    new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".png";

            FileUtils.copyFile(src, new File(path));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}