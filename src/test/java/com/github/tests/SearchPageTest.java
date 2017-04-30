package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import com.github.pages.searchpage.LanguagePanel;
import com.github.pages.searchpage.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.pages.searchpage.LabelPredicates.is;
import static com.github.pages.searchpage.LabelPredicates.isNot;

public class SearchPageTest {

    WebDriver driver;
    SearchPage search;

    @BeforeMethod
    public void setup() {
        driver = SeleniumDriver.getDriver();
        search = new SearchPage(driver, SearchPage.PAGE_URL);
    }

    @Test
    public void checkLanguageFilterWorks() {

        LanguagePanel java = LanguagePanel.JAVA;

        search.enterSearchWord(java.toString())
                .clickSearch()
                .selectLanguage(java)
                .checkLanguageLabels(is(java));

        // Negative test
        LanguagePanel html = LanguagePanel.HTML;
        LanguagePanel python = LanguagePanel.PYTHON;

        search.selectLanguage(html)
                .checkLanguageLabels(isNot(python));
    }

}
