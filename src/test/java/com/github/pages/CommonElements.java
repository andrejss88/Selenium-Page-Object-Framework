package com.github.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Andre on 9/14/2016.
 */
public class CommonElements {
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    protected WebElement signInBtn;

    @FindBy(how = How.LINK_TEXT, using = "Sign up")
    protected WebElement signUpBtn;

//    public CommonElements(){
//
//    }

    public void clickOn(WebElement element) {
        element.click();
    }
}
