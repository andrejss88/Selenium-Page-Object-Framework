package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 */
public abstract class AbstractGitHubPage {

    protected static String BASE_URL = "https://github.com/";

    @FindBy(tagName = "h1")
    protected WebElement heading;

    /**
     * Shared between all pages, avoids declaring in each Page Object
     */

    protected WebDriver driver;


    public boolean isPageOpened(String headingText){
        return heading.getText().contains(headingText);
    }
}
