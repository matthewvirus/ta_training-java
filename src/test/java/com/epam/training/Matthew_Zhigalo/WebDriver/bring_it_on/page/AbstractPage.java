package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected static final int WAITING_TIME = 10;
    protected abstract AbstractPage openPage();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

}