package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import com.github.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.fluentselenium.utils.ElementUtil.checkElementEnabled;


public class SignInPageTest {
    WebDriver driver;
    SignInPage signInPage;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
        signInPage = new SignInPage(driver, SignInPage.PAGE_URL);
    }

    /**
     * Sign in button is actually always enabled,
     * so these tests are more for the purpose of code demonstration
     */

    @Test
    public void checkSignBtnEnabled() {
        Assert.assertEquals(signInPage.getSignInBtn().isEnabled(), true, "Sign In button is disabled but should be enabled");
    }

    /**
     * Same, but with the help of a custom Util class.
     * Pro: more concise
     * Con: each additional abstraction = fail message is more vague
     */
    @Test
    public void checkSignInBtnEnabled_alternativeWay() {
        checkElementEnabled(signInPage.getSignInBtn(), true);
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}