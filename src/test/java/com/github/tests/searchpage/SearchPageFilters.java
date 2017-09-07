package com.github.tests.searchpage;

import com.github.pages.searchpage.Language;
import com.github.tests.abstractpagetest.AbstractSearchPageTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.github.pages.searchpage.FilterPredicates.is;
import static com.github.pages.searchpage.FilterPredicates.isNot;

/**
 * Tests here use a different design method: a simple Fluent Interface,
 * where methods are chained together to form a readable sequence of actions
 */
public class SearchPageFilters extends AbstractSearchPageTest {

    @Test
    public void checkLanguageFilterWorks() {

        Language java = Language.JAVA;

        search.enterSearchWord(java)
                .clickSearch()
                .selectLanguage(java)
                .checkLanguageLabels(is(java));
    }

    @Test
    public void checkLanguageFilterWorksNegativeTest(){

        Language html = Language.HTML;
        Language python = Language.PYTHON;

        search.enterSearchWord(html)
                .clickSearch()
                .selectLanguage(html)
                .checkLanguageLabels(isNot(python));
    }

    @Test
    public void checkFilterTotalRepoCount(){

        Language js = Language.JAVASCRIPT;

        search.enterSearchWord(js)
                .clickSearch();

        int repoCount = search.getRepoCountFor(js);

        search.selectLanguage(js);

        int totalCount = search.getTotalRepoCount();

        // For some reason filter results count may not match
        // depending on searched keyword
        Assert.assertEquals(repoCount, totalCount);
    }

}
