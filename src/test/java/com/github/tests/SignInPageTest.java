package com.github.tests;

import com.github.helpers.ElementUtil;
import com.github.pages.SignInPage;
import com.github.setup.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SignInPageTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
    }

    /**
     * Sign in button is actually always enabled,
     * so these tests are more for the purpose of code demonstration
     */

    @Test
    public void checkSignBtnEnabled() {
        SignInPage signInPage =  new SignInPage(driver, SignInPage.PAGE_URL);
        Assert.assertEquals(signInPage.getSignInBtn().isEnabled(), true, "Sign In button is disabled but should be enabled");
    }

    /**
     * Same, but with the help of a custom Util class.
     * Pro: more concise
     * Con: each additional abstraction = fail message is more vague
     */
    @Test
    public void checkSignInBtnEnabled_alternativeWay() {
        SignInPage signInPage = new SignInPage(driver, SignInPage.PAGE_URL);
        ElementUtil.checkElementEnabled(signInPage.getSignInBtn(), true);
    }


    @AfterMethod
    public void close() {
        driver.close();
    }
}