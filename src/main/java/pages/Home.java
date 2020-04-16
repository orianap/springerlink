package pages;

import com.springerlink.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Home extends BasePage
{
    private final String pageURL = getBaseURL();
    public Home(WebDriver driver)
    {
        super(driver);
    }

    public String getUrl() {
        return pageURL;
    }

    public Home open()
    {
        driver.get(pageURL);
        return this;
    }
}
