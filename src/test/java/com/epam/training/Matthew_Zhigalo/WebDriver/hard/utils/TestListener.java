package com.epam.training.Matthew_Zhigalo.WebDriver.hard.utils;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private void saveScreenshot() {
        File screenshot = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(
                    ".//target/screenshots/"
                    + getCurrentDateAndTime()
                    + ".png"));
        } catch (IOException exception) {
            logger.error("Failed to save screenshot " + exception.getLocalizedMessage());
        }
    }

    private String getCurrentDateAndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
