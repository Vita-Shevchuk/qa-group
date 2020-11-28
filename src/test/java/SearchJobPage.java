import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchJobPage {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://jobs.workable.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void findValidValue (){
        //connecting SearchJobElements class with the current one to use locators and methods described there
        SearchJobElements searchElements = new SearchJobElements(driver);
        String positionInputText = "QA Engineer";
        searchElements.searchFieldPositionInput (positionInputText);
        searchElements.searchFieldLocationInput ("Kharkov");
        searchElements.searchSubmitClick();
        // wait for search outcome
        searchElements.waitForSearchResultsPageLoaded();
        searchElements.assertThatFirstResultItemContains(positionInputText);
    }

    @Test
    public void noSearchResultsCheck (){
        SearchJobElements searchElements = new SearchJobElements(driver);
        searchElements.searchFieldPositionInput("&%34");
        searchElements.searchFieldLocationInput("#1~+");
        searchElements.searchSubmitClick();
        searchElements.waitForInvalidSearchResultsPageLoaded();
        searchElements.checkAbsenceOfItems();
    }
}
