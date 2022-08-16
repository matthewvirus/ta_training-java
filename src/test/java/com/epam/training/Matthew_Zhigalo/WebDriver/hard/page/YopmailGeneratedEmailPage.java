package com.epam.training.Matthew_Zhigalo.WebDriver.hard.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailGeneratedEmailPage extends AbstractPage {

    private final By checkInboxButtonSelector = By.cssSelector( ".tooltip + button");
    private final By generatedMailSelector = By.cssSelector("#egen");

    public YopmailGeneratedEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getGeneratedEmail() {
        return webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(generatedMailSelector))
                .getText();
    }

    public YopmailInboxPage checkForInboxMessages() {
        webDriverWait()
                .until(ExpectedConditions
                        .elementToBeClickable(checkInboxButtonSelector))
                .click();
        return new YopmailInboxPage(driver);
    }

    @Override
    protected YopmailGeneratedEmailPage openPage() {
        throw new RuntimeException();
    }
}
