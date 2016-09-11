package com.github.tests;

import com.github.pages.HomePage;
import com.github.pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignInTest {
    WebDriver driver;

    @Before
    public void setup() {
        //use FF Driver
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void applyAsDeveloper() {
        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnSignIn();


        //Create object of SignInPage
        SignInPage signInPage = new SignInPage(driver);

        //Check if page is opened
        Assert.assertTrue("Could not assert Sign In Page opened", signInPage.isPageOpened());

    }

    @After
    public void close() {
        driver.close();
    }
}