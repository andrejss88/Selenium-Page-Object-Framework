package com.github.tests.abstractpagetest;

import com.github.pages.HomePage;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractHomePageTest extends AbstractPageTest {

    protected HomePage home;

    @BeforeMethod
    public void commonSetup() {

        home = HomePage.openPage(driver);
    }


}
