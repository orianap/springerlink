package com.springerlink.testpages;

import com.springerlink.basetest.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pages.AdvancedSearch;
import pages.HomePage;

public class AdvancedSearchPageTest extends BaseTest
{
    private static AdvancedSearch advancedSearchPage;

    @Before
    public void beforeTest()
    {
        advancedSearchPage = new AdvancedSearch(getDriver());
        advancedSearchPage.open();
    }

    @After
    public void afterTest()
    {
        advancedSearchPage.close();
    }

    @Test
    public void searchForPublishInTheFuture()
    {
        advancedSearchPage.insertAllWords("Ethnobotany of Asia")
                .insertExactPhrase("Mountain Regions")
                .insertAtLeastOneWord("Ethnobotany potato")
                .insertWithoutTheWords("cat")
                .insertTitleContains("Central Asia")
                .insertAuthorEditor("Ketevan Batsatsashvili")
                .insertStartYear("2027")    //insert a future year as startYear
                .insertEndYear("2021")      //insert a future year as endYear where startYear > endYear
                .clickAdvancedSearchButton()
                .checkNoResultsFound();

    }
}
