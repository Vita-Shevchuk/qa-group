import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchJobElements {
    private WebDriver driver;

    public SearchJobElements(WebDriver driver) {
        this.driver = driver;
    }

    // define elements
    By searchFieldPosition = By.xpath("//input[@data-ui='search-input']");
    By searchFieldLocation = By.xpath("//input[@data-ui='location-input']");
    By submitSearchButton = By.xpath("//input[@data-ui='search-submit']");
    By searchResultsItem = By.xpath("//a[@data-ui='job-title' and contains (text(), 'QA Engineer')]");
    By noSearchResults = By.xpath("//strong[contains (text(),'No results found for')]");

    //create methods
    public SearchJobElements searchFieldPositionInput(String search) {
        driver.findElement(searchFieldPosition).sendKeys(search);
        return this;
    }
    public SearchJobElements searchFieldLocationInput (String search){
        driver.findElement(searchFieldLocation).sendKeys(search);
        return this;
    }
    public SearchJobElements searchSubmitClick () {
        driver.findElement(submitSearchButton).click();
        return this;
    }

    //explicit wait
    public SearchJobElements waitForSearchResultsPageLoaded(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains (text(),'latest jobs for')]")));
        return this;
    }

    public SearchJobElements waitForInvalidSearchResultsPageLoaded(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//strong[contains (text(),'No results found for')]")));
        return this;
    }


    //method for check the first item in search results
    public SearchJobElements assertThatFirstResultItemContains(String item) {
        Assert.assertTrue(driver.findElement(searchResultsItem).getText().contains(item));
        return this;
    }

    // negative test for invalid input data
    public SearchJobElements checkAbsenceOfItems (){
        Assert.assertTrue(driver.findElement(noSearchResults).getText().contains("No results found for"));
        return this;
    }


}
