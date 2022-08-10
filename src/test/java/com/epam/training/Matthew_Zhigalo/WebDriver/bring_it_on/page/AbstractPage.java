package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final int WAITING_TIME = 10;
    protected abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriverWait webDriverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
    }

}