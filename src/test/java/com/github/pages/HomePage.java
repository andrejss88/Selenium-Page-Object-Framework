package com.github.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractGitHubPage {

    public static String PAGE_URL = BASE_URL ;
    public static String HEADING = "How people build";

    //Locators unique to Homepage
    @FindBy(how = How.CLASS_NAME, using = "display-heading-1")
    private WebElement heading;



    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement signUpBtn;

    /**
     * Instantiate for the purpose of initializing page's elements
     * i.e. when you come from a different page
     */


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Instantiate when you want to start the test from this page
     * @param pageUrl : use the PAGE_URL of this class
     */
    public HomePage(WebDriver driver, String pageUrl) {
        this(driver);
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
        Assert.assertTrue("Could not assert Home Page opened", this.isPageOpened(HomePage.HEADING));
    }

    public void clickSignIn() {
        signUpBtn.click();
    }


}