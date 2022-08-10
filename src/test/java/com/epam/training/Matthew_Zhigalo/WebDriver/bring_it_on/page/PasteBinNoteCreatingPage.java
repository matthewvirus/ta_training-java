package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.page;

import com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.model.PasteBinModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class PasteBinNoteCreatingPage extends AbstractPage {

    private static final String MAIN_PAGE_URL = "https://pastebin.com";

    @FindBy (xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement inputPasteField;

    @FindBy (css = "#postform-expiration + span")
    private WebElement pasteExpirationSelection;

    @FindBy (css = "#postform-format + span")
    private WebElement syntaxHighlightingSelection;

    @FindBy (xpath = "//*[contains(@id, 'postform-name')]")
    private WebElement pasteTitleField;

    @FindBy (xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement createNewPasteButton;

    private final By expirationTimeSelector = By.cssSelector("#select2-postform-expiration-results > li");
    private final By highlightingSelector = By.cssSelector("#select2-postform-format-results > li + li > ul > li");

    public PasteBinNoteCreatingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public PasteBinNoteCreatingPage openPage() {
        driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public PasteBinNotePage createNewPaste(PasteBinModel pasteBinModel) {
        inputPasteText(pasteBinModel.getPasteText());
        selectPasteExpiration(pasteBinModel.getExpirationTime());
        selectSyntaxHighlighting(pasteBinModel.getTextHighlighting());
        pasteTitleField.sendKeys(pasteBinModel.getPasteTitle());
        createNewPasteButton.click();
        return new PasteBinNotePage(driver);
    }

    private void inputPasteText(String pasteText) {
        inputPasteField.sendKeys(pasteText);
    }

    private void selectPasteExpiration(String time) {
        pasteExpirationSelection.click();
        List<WebElement> pasteExpirationList = webDriverWait()
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(expirationTimeSelector));
        for (WebElement element : pasteExpirationList) {
            if (time.equalsIgnoreCase(element.getText())) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("Time isn't correct. Try again with right data.");
    }

    private void selectSyntaxHighlighting(String textHighlighting) {
        syntaxHighlightingSelection.click();
        List<WebElement> pasteExpirationList = webDriverWait()
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(highlightingSelector));
        for (WebElement element : pasteExpirationList) {
            if (textHighlighting.equalsIgnoreCase(element.getText())) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("There is no same language in list.");
    }

}