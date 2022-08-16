package com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopmailInboxPage extends AbstractPage {

    private final By mailTextFrame = By.cssSelector("#ifmail");
    private final By refreshButtonSelector = By.cssSelector("#refresh");
    private final By totalEstimatedCostFromMail = By.cssSelector("td[colspan='3'] + td > h3");

    public YopmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public YopmailInboxPage goToMessage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exception) {
            throw new RuntimeException();
        }
        refreshMessages()
                .switchTo(mailTextFrame);
        return this;
    }

    private void switchTo(By frame) {
        driver.switchTo()
                .frame(webDriverWait()
                        .until(ExpectedConditions
                                .presenceOfElementLocated(frame)));
    }

    private YopmailInboxPage refreshMessages() {
        webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(refreshButtonSelector))
                .click();
        return this;
    }

    public String getEstimatedCostFromEmail() {
        return webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(totalEstimatedCostFromMail))
                .getText();
    }

    @Override
    protected YopmailInboxPage openPage() {
        throw new RuntimeException();
    }
}
