package com.epam.training.Matthew_Zhigalo.WebDriver.hard.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudMainPage extends AbstractPage {

    private static final String CLOUD_MAIN_PAGE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();
    private final By searchFieldCssSelector = By.cssSelector(".devsite-searchbox > input");

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SearchResultsPage sendSearchQuery(String searchTerm) {
        WebElement searchField = webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(searchFieldCssSelector));
        searchField.sendKeys(searchTerm);
        searchField.submit();
        return new SearchResultsPage(driver, searchTerm);
    }

    @Override
    public GoogleCloudMainPage openPage() {
        driver.navigate().to(CLOUD_MAIN_PAGE_URL);
        logger.info("Opened page " + CLOUD_MAIN_PAGE_URL);
        return this;
    }

}