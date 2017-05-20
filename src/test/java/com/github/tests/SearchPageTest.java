package com.github.tests;

import com.fluentselenium.setup.SeleniumDriver;
import com.github.pages.searchpage.Language;
import com.github.pages.searchpage.SearchPage;
import com.github.pages.searchpage.SortOptions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.github.pages.searchpage.FilterPredicates.is;
import static com.github.pages.searchpage.FilterPredicates.isNot;
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

        Language java = Language.JAVA;

        search.enterSearchWord(java.toString())
                .clickSearch()
                .selectLanguage(java)
                .checkLanguageLabels(is(java));

        // Negative test
        Language html = Language.HTML;
        Language python = Language.PYTHON;

        search.selectLanguage(html)
                .checkLanguageLabels(isNot(python));
    }

    @Test
    public void checkFilterTotalRepoCount(){

        Language js = Language.JAVASCRIPT;

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
                .sortBy(SortOptions.MOST_STARS)
                .getStarRatings();

        Assert.assertTrue(isSorted(ratingList));

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
