package com.github.tests.searchpage;

import com.github.tests.abstractpagetest.AbstractSearchPageTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.github.pages.searchpage.SearchPage.isSorted;
import static com.github.pages.searchpage.SortOptions.MOST_STARS;

public class SearchPageSort extends AbstractSearchPageTest {


    @Test
    public void checkSortBy(){

        List<Double> ratingList = search.enterSearchWord("Java")
                .clickSearch()
                .sortBy(MOST_STARS)
                .getStarRatings();

        Assert.assertTrue(isSorted(ratingList));

    }
}
