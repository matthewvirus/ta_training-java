package bring_it_on.page;

import bring_it_on.model.PasteBinModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    @Override
    public PasteBinNoteCreatingPage openPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public PasteBinNotePage createNewPaste(PasteBinModel pasteBinModel) {
        inputPasteField.sendKeys(pasteBinModel.getPasteText());
        selectPasteExpiration(pasteBinModel.getExpirationTime());
        pasteTitleField.sendKeys(pasteBinModel.getPasteTitle());
        selectSyntaxHighlighting(pasteBinModel.getTextHighlighting());
        createNewPasteButton.click();
        return new PasteBinNotePage(driver);
    }

    private void selectPasteExpiration(String time) {
        pasteExpirationSelection.click();
        List<WebElement> pasteExpirationList = getSelectionElements(driver, expirationTimeSelector);
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
        List<WebElement> pasteExpirationList = getSelectionElements(driver, highlightingSelector);
        for (WebElement element : pasteExpirationList) {
            if (textHighlighting.equalsIgnoreCase(element.getText())) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("There is no same language in list.");
    }

    private List<WebElement> getSelectionElements(WebDriver driver, By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(selector));
    }

}