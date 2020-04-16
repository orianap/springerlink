package com.springerlink.testpages;


import com.springerlink.basetest.BaseTest;
import org.junit.*;
import pages.HomePage;

public class HomePagePageTests extends BaseTest
{
    private static HomePage homePage;

    @Before
    public void beforeTest()
    {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @After
    public void afterTest()
    {
        homePage.close();
    }

    @AfterClass
    public static void afterClass()
    {
        homePage.quit();
    }

    @Test
    public void searchForTextReturnsResults()
    {
        homePage.searchFor("corona virus")
                .returnsResults();
    }

}
