package com.epam.training.Matthew_Zhigalo.WebDriver.hard.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailGeneratedEmailPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailInboxPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.YopmailMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.TestModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.service.CompletedTestModel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateVirtualComputeEngineTest {

    private WebDriver driver;
    private GoogleCloudPricingCalculatorPage pricingCalculatorPage;
    private final TestModel testModel = CompletedTestModel.completeTestModel();

    @BeforeMethod()
    public void startBrowserSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pricingCalculatorPage = new GoogleCloudMainPage(driver)
                .openPage()
                .sendSearchQuery("Google Cloud Pricing Calculator")
                .clickOnElementWithSearchTerm()
                .addToEstimate();
    }

    @Test (description = "This test check if result data corresponds to test data")
    public void totalEstimatedCostCorrespondToTheGivenTest() {
        Assert.assertTrue(pricingCalculatorPage.getRegion()
                .contains(testModel.getRegion()));
        Assert.assertTrue(pricingCalculatorPage.getCommitmentTerm()
                .contains(testModel.getCommitmentTerm()));
        Assert.assertTrue(pricingCalculatorPage.getClassOfVM()
                .contains(testModel.getVmClass()));
        Assert.assertTrue(pricingCalculatorPage.getInstanceType()
                .contains(testModel.getInstanceType()));
        Assert.assertTrue(pricingCalculatorPage.getLocalSSDSize()
                .contains(testModel.getSsdSize()));
        Assert.assertTrue(pricingCalculatorPage.getTotalEstimatedCost()
                .contains(testModel.getEstimatedCost()));
    }

    @Test (description = "This test check if total estimated cost corresponds to cost from email")
    public void emailEstimatedCostCorrespondToCostFromFormTest() {
        String priceOnPricingCalculatorPage = pricingCalculatorPage.getTotalEstimatedCost();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        List<String> openedTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openedTabs.get(1));

        YopmailGeneratedEmailPage yopmailGeneratedEmailPage = new YopmailMainPage(driver)
                .openPage()
                .generateNewMail();
        String email = yopmailGeneratedEmailPage.getGeneratedEmail();
        YopmailInboxPage yopmailInboxPage = yopmailGeneratedEmailPage.checkForInboxMessages();

        driver.switchTo().window(openedTabs.get(0));

        pricingCalculatorPage.sendEstimatedCostToEmail(email);

        driver.switchTo().window(openedTabs.get(1));

        String estimatedCostFromMail = yopmailInboxPage
                .goToMessage()
                .getEstimatedCostFromEmail();
        Assert.assertTrue(priceOnPricingCalculatorPage.contains(estimatedCostFromMail));
    }

    @AfterMethod()
    public void tearDownBrowserSession() {
        driver.quit();
        driver = null;
    }

}