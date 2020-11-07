import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLogoutTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/login");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1, description = "login and check elements")
    public void testLogin(){
        //define elements
        WebElement loginElement = driver.findElement(By.id("txtUsername"));

        WebElement passwElement = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

        loginElement.sendKeys("Admin");
        passwElement.sendKeys("admin123");
        loginButton.click();

        WebElement marketplaceButton = driver.findElement(By.id("MP_link"));
        Assert.assertEquals(marketplaceButton.getAttribute("value"), "Marketplace");

        WebElement welcomeUser = driver.findElement(By.id("welcome"));
        Assert.assertEquals(welcomeUser.getText(), "Welcome Paul");
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"));

        //back to previous page
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
        driver.navigate().refresh();

        // assert error message

       Assert.assertTrue(driver.findElement(By.xpath("//div[@class='message warning']")).getText().contains("Invalid Request"));

       Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message warning']")).getText(), "Invalid Request");
    }
}
