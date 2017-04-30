package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import com.github.pages.searchpage.LanguagePanel;
import com.github.pages.searchpage.SearchOptions;
import com.github.pages.searchpage.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.github.pages.searchpage.LabelPredicates.is;
import static com.github.pages.searchpage.LabelPredicates.isNot;
import static com.github.pages.searchpage.SearchPage.isSorted;

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

    @Test
    public void checkFilterTotalRepoCount(){

        LanguagePanel js = LanguagePanel.JAVASCRIPT;

        search.enterSearchWord(js.toString())
                .clickSearch();

        int repoCount = search.getRepoCountFor(js);

        search.selectLanguage(js);

        int totalCount = search.getTotalRepoCount();

        // For some reason filter results count may not match
        // depending on searched keyword
        Assert.assertEquals(repoCount, totalCount);
    }

    @Test
    public void checkSortBy(){

        List<Double> ratingList = search.enterSearchWord("Java")
                .clickSearch()
                .sortBy(SearchOptions.MOST_STARS)
                .getStarRatings();

        Assert.assertTrue(isSorted(ratingList));

    }

}
