package com.springerlink.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public abstract class BasePage
{
    protected WebDriver driver;
    private final String baseURL = "https://link.springer.com/";

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public abstract String getUrl();

    public BasePage open()
    {
        driver.get(getUrl());
        return this;
    }

    public String getBaseURL()
    {
        return this.baseURL;
    }

    public Boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0) {
            return true;
        } else return false;
    }

    public void quit()
    {
        driver.quit();
    }

    public void close()
    {
        driver.close();
    }

}
