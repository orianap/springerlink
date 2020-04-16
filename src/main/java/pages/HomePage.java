package pages;

import static org.junit.Assert.*;
import com.springerlink.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage
{
    private final String pageURL = getBaseURL();

    @FindBy(how = How.CSS, using = "#query")
    private WebElement searchTextInput;

    @FindBy(how = How.CSS, using = "#search")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "#number-of-search-results-and-search-terms > strong")
    private List<WebElement> searchResult;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public String getUrl() {
        return pageURL;
    }

    public HomePage open()
    {
        driver.get(pageURL);
        return this;
    }

    public HomePage searchFor(String text)
    {
        if(!searchTextInput.isDisplayed()){
            fail("Search Text input not found in DOM");
        }
        searchTextInput.sendKeys(text);
        searchButton.click();
        return this;
    }

    public HomePage returnsResults()
    {
        String resultsStr = searchResult.get(0).getText().replace(",","");
        int numberOfResults = Integer.parseInt(resultsStr);
        assertTrue("FAILED: No Results Found",numberOfResults > 0 );
        return this;
    }

    public HomePage checkSearchTerm(String term)
    {
        String actualSearchTerm = searchResult.get(1).getText();
        assertEquals(term, actualSearchTerm);
        return this;
    }
}
