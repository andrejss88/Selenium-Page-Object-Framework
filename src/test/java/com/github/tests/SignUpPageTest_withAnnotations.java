package com.github.tests;

import com.github.dataproviders.UserDetailsProvider;
import com.github.pages.SignUpPage;
import com.github.pages.common.CommonActions;
import com.github.setup.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignUpPageTest_withAnnotations {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
    }

    /**
     * If the test is flaky for whatever reason,
     * invoke it several times
     */
    @Test(invocationCount = 2)
    public void checkSignUpPageStarts() {
        SignUpPage signInPage = new SignUpPage(driver, SignUpPage.PAGE_URL);
        Assert.assertTrue(signInPage.isPageOpened(), "Could not assert Sign Up Page opened");
    }

    // Will run if above passes
    @Test(dependsOnMethods = {"checkSignUpPageStarts"})
    public void signUpStep1() {
        SignUpPage signUpPage = new SignUpPage(driver, SignUpPage.PAGE_URL);
        CommonActions common = new CommonActions(driver);

        common.fillInNewUserDetails("test", "test", "test");
        signUpPage.clickCreateAccount();
        signUpPage.checkAccountCreationSuccessful();
    }

    @Test(dependsOnMethods = {"signUpStep1"})
    public void fillInStep2() {
        // Some methods to test Step 2 of the registration
        System.out.println("But this will simply not run because signUpStep1 will fail");
    }

    @Test(dataProvider = "dummyUserDetails", dataProviderClass = UserDetailsProvider.class)
    public void signUpStep1_withDataProvider(String userName, String email, String password) {
        SignUpPage signUpPage = new SignUpPage(driver, SignUpPage.PAGE_URL);
        CommonActions common = new CommonActions(driver);

        common.fillInNewUserDetails(userName, email, password);

        signUpPage.clickCreateAccount();
        signUpPage.checkAccountCreationFailed();
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }


}
