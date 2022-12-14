package com.epam.training.Matthew_Zhigalo.WebDriver.hard.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.epam.training.Matthew_Zhigalo.WebDriver.hard.page.AbstractPage.webDriverWait;

public class DropdownUtils {

    public static void clickOnDropdownListElement(String selector) {
        WebElement dropdownListItem = webDriverWait()
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .xpath(selector)));
        dropdownListItem.click();
        webDriverWait().until(ExpectedConditions.invisibilityOf(dropdownListItem));
    }

}
