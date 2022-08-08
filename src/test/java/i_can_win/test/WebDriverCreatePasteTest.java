package i_can_win.test;

import i_can_win.page.PasteBinMainNotePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverCreatePasteTest {

    private static WebDriver driver;
    private static final String PASTE_TEXT = "Hello from WebDriver";
    private static final String PASTE_EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_TITLE = "helloweb";

    @BeforeMethod()
    public void startBrowser() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteWithSimpleDetails() {
        new PasteBinMainNotePage(driver)
                .openPage()
                .inputPasteText(PASTE_TEXT)
                .selectPasteExpiration(PASTE_EXPIRATION_TIME)
                .inputPasteTitle(PASTE_TITLE)
                .clickOnCreateButton();
    }

    @AfterMethod()
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

}