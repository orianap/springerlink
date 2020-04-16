package com.springerlink.testpages;


import com.springerlink.basetest.BaseTest;
import org.junit.*;
import pages.Home;

public class HomePageTests extends BaseTest
{
    private static Home homePage;

    @Test
    public void test()
    {
        homePage = new Home(getDriver());
        homePage.open();
    }

    @After
    public void afterTest()
    {
        homePage.close();
    }

}
