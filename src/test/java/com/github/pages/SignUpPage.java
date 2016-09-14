package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andre on 9/14/2016.
 */
public class SignUpPage {

    @FindBy(tagName = "h1")
    WebElement heading;
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        return heading.getText().contains("Join GitHub");
    }
}
