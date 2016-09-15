package com.github.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BadHomePage  {

    public static String PAGE_URL = "https://github.com/" ;

    private WebDriver driver;

    //Locators unique to Homepage
    @FindBy(how = How.CLASS_NAME, using = "display-heading-1")
    private WebElement heading;

    public static String HEADING = "How people build";

    /**
     * Instantiate for the purpose of initializing page's elements
     * i.e. when you come from a different page
     */

    public BadHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }


    public boolean isPageOpened() {
        return heading.getText().contains("How people build");
    }

}