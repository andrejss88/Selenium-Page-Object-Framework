package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class AbstractPageTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = SeleniumDriver.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}