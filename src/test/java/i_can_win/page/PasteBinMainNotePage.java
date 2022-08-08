package i_can_win.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PasteBinMainNotePage extends AbstractPage {

    private static final String MAIN_PAGE_URL = "https://pastebin.com";

    @FindBy (xpath = "//*[contains(@id, 'postform-text')]")
    private WebElement inputPasteField;

    @FindBy (css = "#postform-expiration + span")
    private WebElement pasteExpirationSelection;

    @FindBy (xpath = "//*[contains(@id, 'postform-name')]")
    private WebElement pasteTitleField;

    @FindBy (xpath = "//*[contains(@class, 'btn -big')]")
    private WebElement createNewPasteButton;

    public PasteBinMainNotePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PasteBinMainNotePage openPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public PasteBinMainNotePage inputPasteText(String pasteText) {
        inputPasteField.sendKeys(pasteText);
        return this;
    }

    public PasteBinMainNotePage selectPasteExpiration(String time) {
        pasteExpirationSelection.click();
        List<WebElement> pasteExpirationList = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.cssSelector("#select2-postform-expiration-results > li")));
        for (WebElement element : pasteExpirationList) {
            if (time.equalsIgnoreCase(element.getText())) {
                element.click();
                return this;
            }
        }
        throw new RuntimeException("Time isn't correct. Try again with right data.");
    }

    public PasteBinMainNotePage inputPasteTitle(String pasteTitleText) {
        pasteTitleField.sendKeys(pasteTitleText);
        return this;
    }

    public void clickOnCreateButton() {
        createNewPasteButton.click();
    }

}