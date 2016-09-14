package com.github.tests;

import com.github.pages.HomePage;
import com.github.pages.SearchPage;
import com.github.pages.SignInPage;
import com.github.pages.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andre on 9/14/2016.
 */
public class HomePageTest {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void goToHomePage() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue("Could not assert Home Page opened", home.isPageOpened());
    }

    @Test
    public void checkSignInBtnWorks() {
        HomePage home = new HomePage(driver);
        home.clickOnSignIn();

        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue("Could not assert Sign In Page opened", signInPage.isPageOpened());

    }

    @Test
    public void checkSignUpBtnWorks() {
        HomePage home = new HomePage(driver);
        home.clickOnSignUp();

        SignUpPage signUpPage = new SignUpPage(driver);
        Assert.assertTrue("Could not assert Sign Up Page opened", signUpPage.isPageOpened());

    }

    @Test
    public void checkSearchWorks() {
        HomePage home = new HomePage(driver);
        home.search("test repo");

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue("Could not assert Search Page opened", searchPage.isPageOpened());
    }

    @After
    public void close() {
        driver.close();
    }
}
