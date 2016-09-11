package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static String PAGE_URL = "https://github.com/";
    private WebDriver driver;
    //Locators
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signIn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignIn() {
        signIn.click();
    }

}