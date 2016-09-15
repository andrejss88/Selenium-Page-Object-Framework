package com.github.tests;

import com.github.pages.HomePage;
import com.github.pages.SearchPage;
import com.github.pages.SignInPage;
import com.github.pages.SignUpPage;
import com.github.pages.common.CommonHeaderElements;
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
    public void checkSignInBtnWorks() {
        // Arrange
        new HomePage(driver, HomePage.PAGE_URL);
        CommonHeaderElements headerSection = new CommonHeaderElements(driver);
        SignInPage signInPage = new SignInPage(driver);

        //Act
        headerSection.clickOnHeaderSignIn();

        // Assert
        Assert.assertTrue("Could not assert Sign In Page opened", signInPage.isPageOpened(SignInPage.HEADING));

    }

    @Test
    public void checkSignUpBtnWorks() {
        // Arrange
        new HomePage(driver, HomePage.PAGE_URL);
        CommonHeaderElements headerSection = new CommonHeaderElements(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        // Act
        headerSection.clickOnHeaderSignUp();

        // Assert
        Assert.assertTrue("Could not assert Sign Up Page opened", signUpPage.isPageOpened(SignUpPage.HEADING));

    }

    @Test
    public void checkSearchWorks() {
        new HomePage(driver, HomePage.PAGE_URL);
        CommonHeaderElements headerSection = new CommonHeaderElements(driver);
        SearchPage searchPage = new SearchPage(driver);

        headerSection.search("test repo");

        Assert.assertTrue("Could not assert Search Page opened", searchPage.isPageOpened(SearchPage.HEADING));
    }

    @After
    public void close() {
        driver.close();
    }
}
