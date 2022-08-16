package com.epam.training.Matthew_Zhigalo.WebDriver.hard.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailMainPage extends AbstractPage {

    private static final String MAIL_GENERATOR_URL = "https://yopmail.com/ru/";

    private final By generateMailButtonXpath = By.xpath("//*[@id=\"listeliens\"]/a[@href='email-generator']");

    public YopmailMainPage(WebDriver driver) {
        super(driver);
    }

    public YopmailGeneratedEmailPage generateNewMail() {
        webDriverWait()
                .until(ExpectedConditions.presenceOfElementLocated(generateMailButtonXpath))
                .click();
        return new YopmailGeneratedEmailPage(driver);
    }

    @Override
    public YopmailMainPage openPage() {
        driver.navigate().to(MAIL_GENERATOR_URL);
        return this;
    }
}