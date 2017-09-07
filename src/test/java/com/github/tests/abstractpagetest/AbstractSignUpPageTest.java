package com.github.tests.abstractpagetest;

import com.github.pages.SignUpPage;
import org.testng.annotations.BeforeMethod;

public class AbstractSignUpPageTest extends AbstractPageTest {

    protected SignUpPage signUpPage;

    @BeforeMethod
    public void commonSetup() {
        signUpPage = SignUpPage.openPage(driver);
    }
}
