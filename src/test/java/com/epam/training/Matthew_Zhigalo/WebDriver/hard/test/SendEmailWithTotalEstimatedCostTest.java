package com.epam.training.Matthew_Zhigalo.WebDriver.hard.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailGeneratedEmailPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailInboxPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SendEmailWithTotalEstimatedCostTest extends CommonConditions {

    @Test (description = "This test check if total estimated cost corresponds to cost from email")
    public void emailEstimatedCostCorrespondToCostFromFormTest() {
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new GoogleCloudMainPage(driver)
                .openPage()
                .sendSearchQuery("Google Cloud Pricing Calculator")
                .clickOnElementWithSearchTerm()
                .addToEstimate();
        String priceOnPricingCalculatorPage = pricingCalculatorPage.getTotalEstimatedCost();
        String pricingCalculatorTab = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        YopmailGeneratedEmailPage yopmailGeneratedEmailPage = new YopmailMainPage(driver)
                .openPage()
                .generateNewMail();
        String yopmailGeneratorTab = driver.getWindowHandle();
        String generatedEmail = yopmailGeneratedEmailPage.getGeneratedEmail();
        YopmailInboxPage yopmailInboxPage = yopmailGeneratedEmailPage.checkForInboxMessages();

        driver.switchTo().window(pricingCalculatorTab);
        pricingCalculatorPage.sendEstimatedCostToEmail(generatedEmail);

        driver.switchTo().window(yopmailGeneratorTab);
        String totalEstimatedCostFromEmail = yopmailInboxPage
                .goToMessage()
                .getEstimatedCostFromEmail();
        Assert.assertTrue(priceOnPricingCalculatorPage.contains(totalEstimatedCostFromEmail));
    }

}