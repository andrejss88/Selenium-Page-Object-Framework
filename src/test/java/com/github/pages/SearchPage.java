package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andre on 9/14/2016.
 */
public class SearchPage extends AbstractGitHubPage{

    public static String PAGE_URL = BASE_URL + "search";
    public static String HEADING = "Search";

    @FindBy(tagName = "h1")
    WebElement heading;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage(WebDriver driver, String pageUrl){
        this(driver);
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }


    // This page has <TABLE>s! perfect!
}
