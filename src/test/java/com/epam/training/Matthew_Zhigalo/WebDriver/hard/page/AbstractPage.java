package com.epam.training.Matthew_Zhigalo.WebDriver.hard.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected static WebDriver driver;
    protected static final int TIMEOUT_SECONDS = 15;

    protected AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
    }

    protected abstract AbstractPage openPage();

    public static WebDriverWait webDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    }

}