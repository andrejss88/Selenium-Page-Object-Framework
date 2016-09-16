package com.github.tests;

import com.github.pages.HomePage;
import com.github.pages.SearchPage;
import com.github.pages.SignInPage;
import com.github.pages.SignUpPage;
import com.github.pages.common.CommonHeaderElements;
import com.github.setup.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


/**
 * Created by Andre on 9/14/2016.
 */
public class HomePageTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
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
        Assert.assertTrue(signInPage.isPageOpened(SignInPage.HEADING), "Could not assert Sign In Page opened");
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
        Assert.assertTrue(signUpPage.isPageOpened(SignUpPage.HEADING), "Could not assert Sign Up Page opened");

    }

    @Test
    public void checkSearchWorks() {
        new HomePage(driver, HomePage.PAGE_URL);
        CommonHeaderElements headerSection = new CommonHeaderElements(driver);
        SearchPage searchPage = new SearchPage(driver);

        headerSection.search("test repo");

        Assert.assertTrue(searchPage.isPageOpened(SearchPage.HEADING), "Could not assert Search Page opened");
    }

    @Test
    public void negativeSignUpTest() {
        HomePage home = new HomePage(driver, HomePage.PAGE_URL);
        SoftAssert soft = new SoftAssert();

        SignUpPage signUpPage = new SignUpPage(driver);
        CommonHeaderElements headerSection = new CommonHeaderElements(driver);

        home.signUp("", "email@email.com", "pass");
        signUpPage.checkSignUpFailed(soft);
        headerSection.clickLogo();


        home.signUp("name", "", "pass");
        signUpPage.checkSignUpFailed(soft);
        headerSection.clickLogo();

        home.signUp("name", "email", "");
        signUpPage.checkSignUpFailed(soft);

        // Will display the same fail assert message 3 times, separated by comma
        soft.assertAll();
    }

    @AfterMethod
    public void close() {
        driver.close();
    }
}
