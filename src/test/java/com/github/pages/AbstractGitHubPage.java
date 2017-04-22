package com.github.pages;

import org.openqa.selenium.WebDriver;

/**
 *
 */
public abstract class AbstractGitHubPage {

    protected static String BASE_URL = "https://github.com/";
    private static String TITLE = "GitHub";

    /**
     * Shared between all pages, avoids declaring in each Page Object
     */

    protected WebDriver driver;


    public boolean isPageOpened() {
        return driver.getTitle().contains(TITLE);
    }
}
