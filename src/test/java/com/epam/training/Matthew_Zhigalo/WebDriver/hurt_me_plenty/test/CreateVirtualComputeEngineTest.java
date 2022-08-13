package com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.model.TestModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page.GoogleCloudMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.service.CompletedTestModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @AfterMethod()
    public void tearDownBrowserSession() {
        driver.quit();
        driver = null;
    }

}