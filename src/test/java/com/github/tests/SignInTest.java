package com.github.tests;

import com.github.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInTest  {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkSignInLoads(){
        SignInPage signInPage =  new SignInPage(driver, SignInPage.PAGE_URL);
        Assert.assertTrue(signInPage.isPageOpened(SignInPage.HEADING), "Could not assert Sign In Page opened");
    }


    @AfterMethod
    public void close() {
        driver.close();
    }
}