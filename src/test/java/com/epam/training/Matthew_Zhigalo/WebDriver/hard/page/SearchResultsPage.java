package com.epam.training.Matthew_Zhigalo.WebDriver.hard.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    private final String searchTerm;
    private final By resultsLinks = By.cssSelector(".gs-title > a");

    public SearchResultsPage(WebDriver driver, String searchTerm) {
        super(driver);
        this.searchTerm = searchTerm;
    }

    public GoogleCloudPricingCalculatorPage clickOnElementWithSearchTerm() {
        List<WebElement> listOfResults = webDriverWait()
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(resultsLinks));
        for (WebElement element : listOfResults) {
            if (element.getText().equalsIgnoreCase(searchTerm)) {
                element.click();
                break;
            }
        }
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    @Override
    protected SearchResultsPage openPage() {
        throw new RuntimeException("Opened the page with empty test data.");
    }

}
