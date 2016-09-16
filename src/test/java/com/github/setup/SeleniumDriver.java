package com.github.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SeleniumDriver {

    static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return driver;
        }
        return driver;
    }

}
