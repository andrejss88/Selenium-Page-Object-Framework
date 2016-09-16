package com.github.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 *
 */
public class ElementUtil {

    //ado-TODO: great candidate to move to Excel/CSV and show Data driven testing - an array of negative inputs

    private static final String INVALID_EMAIL = "test";
    private static final String INVALID_PWD = "t";

    public static boolean checkElementIsDisplayed(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void checkElementEnabled(WebElement element, boolean shouldBeEnabled) {
        boolean elementState = element.isEnabled();
        Assert.assertEquals(elementState, shouldBeEnabled, "The element was expected to be Enabled: " + shouldBeEnabled + " but found Enabled: " + elementState);
    }

    public static void enterInvalidData() {
        // to implement
    }
}
