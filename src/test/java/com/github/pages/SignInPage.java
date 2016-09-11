package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    @FindBy(tagName = "h1")
    WebElement heading;
    private WebDriver driver;

    //Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        //Assertion
        return heading.getText().contains("Sign in to GitHub");
    }
}