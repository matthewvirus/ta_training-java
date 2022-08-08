package bring_it_on.test;

import bring_it_on.model.PasteBinModel;
import bring_it_on.page.PasteBinNoteCreatingPage;
import bring_it_on.page.PasteBinNotePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPasteBinTest {

    private WebDriver driver;
    private static final String SOURCE_TEXT = """
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force""";
    private static final String TEXT_HIGHLIGHTING = "Bash";
    private static final String PASTE_EXPIRATION_TIME = "10 Minutes";
    private static final String PASTE_EXPIRATION_TIME_SHORT = "10 min";
    private static final String PASTE_TITLE = "how to gain dominance among developers";
    PasteBinModel pasteBinModel = new PasteBinModel(
            SOURCE_TEXT,
            PASTE_EXPIRATION_TIME,
            TEXT_HIGHLIGHTING,
            PASTE_TITLE);

    @BeforeMethod()
    public void runBrowserSession() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pageTitleCorrespondsToPasteNameTest() {
        String currentPageTitleText = new PasteBinNoteCreatingPage(driver)
                .openPage()
                .createNewPaste(pasteBinModel)
                .getTitleOnPage();
        System.out.println(currentPageTitleText);
        Assert.assertTrue(currentPageTitleText.equalsIgnoreCase(PASTE_TITLE));
    }

    @AfterMethod()
    public void closeBrowserSession() {
        driver.quit();
        driver = null;
    }

}
