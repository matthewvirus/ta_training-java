package com.epam.training.Matthew_Zhigalo.WebDriver.hard.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.hard.model.TestModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudMainPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.GoogleCloudPricingCalculatorPage;
import com.epam.training.Matthew_Zhigalo.WebDriver.hard.service.CompletedTestModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VirtualComputeEngineDataCorrespondingTest extends CommonConditions {

    private final TestModel testModel = CompletedTestModel.completeTestModel();

    @Test(description = "This test check if result data corresponds to test data")
    public void totalEstimatedCostCorrespondToTheGivenTest() {
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new GoogleCloudMainPage(driver)
                .openPage()
                .sendSearchQuery("Google Cloud Pricing Calculator")
                .clickOnElementWithSearchTerm()
                .addToEstimate();
        Assert.assertTrue(pricingCalculatorPage.getRegion().contains(testModel.getRegion()));
        Assert.assertTrue(pricingCalculatorPage.getCommitmentTerm().contains(testModel.getCommitmentTerm()));
        Assert.assertTrue(pricingCalculatorPage.getClassOfVM().contains(testModel.getVmClass()));
        Assert.assertTrue(pricingCalculatorPage.getInstanceType().contains(testModel.getInstanceType()));
        Assert.assertTrue(pricingCalculatorPage.getLocalSSDSize().contains(testModel.getSsdSize()));
        Assert.assertTrue(pricingCalculatorPage.getTotalEstimatedCost().contains(testModel.getEstimatedCost()));
    }

}
