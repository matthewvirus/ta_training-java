package com.epam.training.Matthew_Zhigalo.WebDriver.hard.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("safari".equals(System.getProperty("browser"))) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}