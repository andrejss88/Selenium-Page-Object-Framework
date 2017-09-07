package com.github.tests.abstractpagetest;

import com.github.pages.SignInPage;
import org.testng.annotations.BeforeMethod;

public class AbstractSignInPageTest extends AbstractPageTest {

    protected SignInPage signInPage;

    @BeforeMethod
    public void commonSetup() {
        signInPage = SignInPage.openPage(driver);
    }
}
