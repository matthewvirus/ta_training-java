package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PasteBinNotePage extends AbstractPage {
    @FindBy(css = ".info-top > h1")
    private WebElement pageTitle;

    @FindBy (xpath = "//a[contains(@class, 'btn -small')]")
    private WebElement syntaxHighlightingType;

    @FindBy (css = ".bash > li")
    private List<WebElement> sourceTextRowsList;

    protected PasteBinNotePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOnPage() {
        return pageTitle.getText();
    }

    public String getSyntaxHighlightingType() {
        return syntaxHighlightingType.getText();
    }

    public String getSourceText() {
        StringBuilder resultTextFromPage = new StringBuilder();
        for (WebElement element : sourceTextRowsList) {
            resultTextFromPage.append(element.getText()).append("\n");
        }
        return resultTextFromPage.toString();
    }

    @Override
    protected PasteBinNotePage openPage() {
        throw new RuntimeException();
    }
}
