package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import com.github.pages.HomePage;
import com.github.pages.SignInPage;
import com.github.pages.SignUpPage;
import com.github.pages.common.CommonActions;
import com.github.pages.common.CommonHeaderElements;
import com.github.pages.searchpage.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomePageTest {

    WebDriver driver;
    CommonHeaderElements header;
    HomePage home;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
        header = new CommonHeaderElements(driver);

        home = new HomePage(driver, HomePage.PAGE_URL);
    }

    @Test
    public void checkSignInBtnWorks() {
        // Arrange

        SignInPage signInPage = new SignInPage(driver);

        //Act
        header.clickOnHeaderSignIn();

        // Assert
        Assert.assertTrue(signInPage.isPageOpened(), "Could not assert Sign In Page opened");
    }

    @Test
    public void checkSignUpBtnWorks() {
        // Arrange
        SignUpPage signUpPage = new SignUpPage(driver);

        // Act
        header.clickOnHeaderSignUp();

        // Assert
        Assert.assertTrue(signUpPage.isPageOpened(), "Could not assert Sign Up Page opened");

    }

    @Test
    public void checkSearchWorks() {

        SearchPage searchPage = new SearchPage(driver);

        header.search("test repo");

        Assert.assertTrue(searchPage.isPageOpened(), "Could not assert Search Page opened");
    }

    @Test
    public void negativeSignUpTest() {

        SoftAssert soft = new SoftAssert();
        SignUpPage signUpPage = new SignUpPage(driver);
        CommonActions common = new CommonActions(driver);

        common.fillInNewUserDetails("", "email@email.com", "pass");
        home.clickSignUp();
        signUpPage.softCheckSignUpFailed();
        header.clickLogo();


        common.fillInNewUserDetails("name", "", "pass");
        home.clickSignUp();
        signUpPage.softCheckSignUpFailed();
        header.clickLogo();

        common.fillInNewUserDetails("name", "email", "");
        home.clickSignUp();
        signUpPage.softCheckSignUpFailed();

        // Will display the same fail assert message 3 times, separated by comma
        soft.assertAll();
    }

    @Test
    // Alternative way to method fillInNewUserDetails
    public void signIn_fails_using_BuilderPattern() {

        // Arrange
        SignUpPage signUpPage = new SignUpPage(driver);

        // Act
        home.enterUserName("user")
                .enterEmail("some@email.com")
                .enterPassword("password")
                .clickSignUp();

        // Assert
        Assert.assertTrue(signUpPage.isPageOpened(), "Could not assert Sign Up Page opened");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
