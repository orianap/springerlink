package com.springerlink.testpages;


import com.springerlink.basetest.BaseTest;
import org.junit.*;
import pages.HomePage;

public class HomePagePageTests extends BaseTest
{
    private static HomePage homePage;

    @Test
    public void test()
    {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @After
    public void afterTest()
    {
        homePage.close();
    }

}
