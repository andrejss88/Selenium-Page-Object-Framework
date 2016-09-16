package com.github.pages;

import com.github.helpers.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by Andre on 9/14/2016.
 */
public class SignUpPage extends AbstractGitHubPage{

    public static String PAGE_URL = BASE_URL + "search";

    /**
     * Incorrect header to make checkSignUpFailed throw failed asserts
     */
    public static String HEADING = "Join GitHub";

    @FindBy(className = "flash-error")
    private WebElement errorToolTip;



    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPage(WebDriver driver, String pageUrl) {
        this(driver);
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

    public void checkSignUpFailed(SoftAssert softAssert) {
        softAssert.assertTrue(this.isPageOpened(SignUpPage.HEADING), "Could not assert Sign Up page is opened");
        softAssert.assertTrue(ElementUtil.checkElementIsDisplayed(errorToolTip), "Could not assert that element: " + errorToolTip + " is displayed");

    }


}
