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

    @FindBy(how = How.CSS, using = "#search-options")
    private WebElement searchOptionsButton;

    @FindBy(how = How.CSS, using = "#advanced-search-link")
    private WebElement advancedSearchLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public String getUrl() {
        return pageURL;
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

    private int getNumberOfResults()
    {
        String resultsStr = searchResult.get(0).getText().replace(",","");
        return Integer.parseInt(resultsStr);
    }

    public HomePage returnsResults()
    {
        int numberOfResults = getNumberOfResults();
        assertTrue("FAILED: Expected results but no results were found",numberOfResults > 0 );
        return this;
    }

    public HomePage checkNoResultsFound()
    {
        int numberOfResults = getNumberOfResults();
        assertTrue("FAILED: Expected no result, but some results were found: "
                + numberOfResults + " results", numberOfResults == 0);
        return this;
    }

    public HomePage checkSearchTerm(String term)
    {
        String actualSearchTerm = searchResult.get(1).getText().replace("'","");
        assertEquals(term, actualSearchTerm);
        return this;
    }

    public AdvancedSearch navigateToAdvancedSearch()
    {
        searchOptionsButton.click();
        advancedSearchLink.click();

        return new AdvancedSearch(driver);
    }
}
