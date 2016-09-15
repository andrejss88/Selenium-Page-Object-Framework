package com.github.badtests;

import com.github.pages.BadHomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andre on 9/14/2016.
 */
public class BadHomePageTest {

    WebDriver driver;


    @Test
    public void checkHomePageLoads() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        BadHomePage home = new BadHomePage(driver);
        Assert.assertTrue(home.isPageOpened());

        driver.close();
    }



}
