package com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page.GoogleCloudMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hurt_me_plenty.page.GoogleCloudPricingCalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateVirtualComputeEngineTest {

    private WebDriver driver;
    private GoogleCloudPricingCalculatorPage pricingCalculatorPage;

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

    @Test
    public void totalEstimatedCostCorrespondToTheGivenTest() {
        Assert.assertTrue(pricingCalculatorPage.getRegion().contains("Frankfurt"));
        Assert.assertTrue(pricingCalculatorPage.getCommitmentTerm().contains("1 Year"));
        Assert.assertTrue(pricingCalculatorPage.getClassOfVM().contains("Regular"));
        Assert.assertTrue(pricingCalculatorPage.getInstanceType().contains("n1-standard-8"));
        Assert.assertTrue(pricingCalculatorPage.getLocalSSDSize().contains("2x375 GiB"));
        Assert.assertTrue(pricingCalculatorPage.getTotalEstimatedCost().contains("1,840.40"));
    }

    @AfterMethod()
    public void tearDownBrowserSession() {
        driver.quit();
        driver = null;
    }

}