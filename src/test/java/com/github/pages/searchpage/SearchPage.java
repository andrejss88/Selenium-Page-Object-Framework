package com.github.pages.searchpage;

import com.github.pages.AbstractGitHubPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.function.Predicate;

import static com.fluentselenium.utils.ConvertUtil.convertToStrings;

public class SearchPage extends AbstractGitHubPage {

    public static String PAGE_URL = BASE_URL + "search";

    private static final String FILTER_ITEM = "//a[contains(@class, 'filter-item')";
    private static final int WAIT_SECONDS = 5;

    @FindBy(how = How.CLASS_NAME, using = "input-block")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    @FindBy(how = How.CLASS_NAME, using = "filter-list")
    private WebElement filterList;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchPage(WebDriver driver, String pageUrl){
        this(driver);
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }

       public SearchPage enterSearchWord(String keyWord) {
        searchInput.sendKeys(keyWord);
        return this;
    }

    public SearchPage clickSearch() {
        searchBtn.click();
        return this;
    }

    public SearchPage selectLanguage(LanguagePanel language) {
        String languageItem = FILTER_ITEM +
                " and text()[normalize-space() = '" + language + "']]";

        WebElement li = driver.findElement(By.xpath(languageItem));
        li.click();

        WebDriverWait wait = new WebDriverWait(driver, WAIT_SECONDS);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath(FILTER_ITEM + " and contains(@class, 'selected')]")));
        return this;

    }

    public SearchPage checkLanguageLabels(Predicate<String> predicate) {

        List<String> langLabels = getLanguageLabels();

        for (String label : langLabels) {
            if (!predicate.test(label)) {
                    Assert.fail("Filtering by language label " + label + " failed");
            }
        }
        return this;
    }


    private List<String> getLanguageLabels() {
        String xpath = "//div[contains(@class, 'repo-list-item')]//div[2]";

        List<WebElement> list = driver.findElements(By.xpath(xpath));

        List<String> stringList = convertToStrings(list);
        return stringList;
    }


    // TODO: Implement table checking on this page (prefixes link)
}
