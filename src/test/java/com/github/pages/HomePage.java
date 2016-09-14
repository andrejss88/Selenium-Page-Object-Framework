package com.github.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static String PAGE_URL = "https://github.com/";
    @FindBy(how = How.LINK_TEXT, using = "Sign up")
    protected WebElement signUpBtn;
    @FindBy(how = How.CLASS_NAME, using = "header-search-input")
    WebElement searchGitHubField;
    @FindBy(how = How.CLASS_NAME, using = "display-heading-1")
    WebElement heading;
    private WebDriver driver;
    //Locators
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signInBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignIn() {
        signInBtn.click();
    }

    public void clickOnSignUp() {
        signUpBtn.click();
    }

    public void search(String searchText) {
        searchGitHubField.sendKeys(searchText);
        searchGitHubField.sendKeys(Keys.RETURN);
    }

    public boolean isPageOpened() {
        return heading.getText().contains("How people build");
    }

}