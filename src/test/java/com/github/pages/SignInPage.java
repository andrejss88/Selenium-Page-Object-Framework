package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends AbstractGitHubPage{

    public static String PAGE_URL = BASE_URL + "login";
    public static String HEADING = "Sign in to GitHub";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Instantiate when you want to start the test from this page
     * @param pageUrl : use the PAGE_URL of this class
     */
    public SignInPage(WebDriver driver, String pageUrl){
        this(driver);
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

}