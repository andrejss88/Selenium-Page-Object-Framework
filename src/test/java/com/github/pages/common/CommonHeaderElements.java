package com.github.pages.common;

import com.github.pages.AbstractGitHubPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andre on 9/14/2016.
 */
public class CommonHeaderElements  {
    private WebDriver driver ;
    /**
     * Common header elements found on various pages
     * Keeping them in a separate class prevents declaring them
     * multiple times in many Page Objects that share the header
     *
     * This keeps things DRY
     */

    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signInBtn;

    @FindBy(how = How.LINK_TEXT, using = "Sign up")
    private WebElement signUpBtn;

    @FindBy(how = How.CLASS_NAME, using = "header-search-input")
    private WebElement searchGitHubField;


    public CommonHeaderElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnHeaderSignIn() {
        signInBtn.click();
    }

    public void clickOnHeaderSignUp() {
        signUpBtn.click();
    }

    public void search(String searchText) {
        searchGitHubField.sendKeys(searchText);
        searchGitHubField.sendKeys(Keys.RETURN);
    }
}
