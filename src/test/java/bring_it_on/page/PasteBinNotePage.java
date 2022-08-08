package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinNotePage extends AbstractPage{

    private static final String regularExpression = " - Pastebin.com";

    @FindBy(xpath = "/html/head/title")
    private WebElement pageTitle;

    protected PasteBinNotePage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOnPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//h1")));
        return pageTitle.getText().replaceAll(regularExpression, "");
    }

    @Override
    protected PasteBinNotePage openPage() {
        throw new RuntimeException();
    }
}
