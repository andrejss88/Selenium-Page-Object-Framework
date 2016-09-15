package com.github.tests;

import com.github.pages.SignInPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignInTest  {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkSignInLoads(){
        SignInPage signInPage =  new SignInPage(driver, SignInPage.PAGE_URL);
        Assert.assertTrue("Could not assert Sign In Page opened", signInPage.isPageOpened(SignInPage.HEADING));
    }


    @After
    public void close() {
        driver.close();
    }
}