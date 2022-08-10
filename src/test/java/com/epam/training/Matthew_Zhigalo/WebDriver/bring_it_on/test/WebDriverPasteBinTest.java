package com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.test;

import com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.model.PasteBinModel;
import com.epam.training.Matthew_Zhigalo.WebDriver.bring_it_on.page.PasteBinNoteCreatingPage;
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
    private static final String PASTE_TITLE = "how to gain dominance among developers";
    private final PasteBinModel pasteBinModel = new PasteBinModel(
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
    public void pageTitleCorrespondsToGivenTest() {
        String currentPageTitleText = new PasteBinNoteCreatingPage(driver)
                .openPage()
                .createNewPaste(pasteBinModel)
                .getTitleOnPage();
        Assert.assertTrue(currentPageTitleText.equalsIgnoreCase(PASTE_TITLE));
    }

//    @Test
//    public void syntaxHighlightingCorrespondsToGivenTest() {
//        String currentSyntaxHighlightingTypeText = new PasteBinNoteCreatingPage(driver)
//                .openPage()
//                .createNewPaste(pasteBinModel)
//                .getSyntaxHighlightingType();
//        Assert.assertTrue(currentSyntaxHighlightingTypeText.equalsIgnoreCase(TEXT_HIGHLIGHTING));
//    }
//
//    @Test
//    public void resultPasteTextCorrespondsToGivenTest() {
//        String currentPasteText = new PasteBinNoteCreatingPage(driver)
//                .openPage()
//                .createNewPaste(pasteBinModel)
//                .getSourceText();
//        Assert.assertTrue(currentPasteText.contentEquals(TEXT_HIGHLIGHTING));
//    }

    @AfterMethod()
    public void closeBrowserSession() {
//        driver.quit();
//        driver = null;
    }

}
