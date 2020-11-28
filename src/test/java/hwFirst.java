import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class hwFirst {
    private WebDriver driver;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.i.ua/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginLogout() {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        //click the login button
        WebElement loginButton = driver.findElement(By.xpath("//a[contains (text(), 'Вход')]"));
        loginButton.click();

        // fill the form and submit
        WebElement nameField = driver.findElement(By.xpath("//div[@class='form']//input[@name='login']"));
        WebElement passwordField = driver.findElement(By.xpath("//div[@class='form']//input[@name='pass']"));
        WebElement submitButton = driver.findElement(By.xpath("//div[@class='form']//input[@type='submit']"));

        nameField.sendKeys("admin@admin.com");
        passwordField.sendKeys("admin123");
        submitButton.click();

        // explicit wait till the Logout button is visible
        //new WebDriverWait(driver,3).until(ExpectedConditions.presenceOfElementLocated(By.xpath
        //                ("//a[@title='выйти']")));

        // assert that user is logged in
        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='выйти']")).isDisplayed());

        // click the logout button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@title='выйти']"));
        logoutButton.click();

        // Assert that user is logged out
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Вход')]")).isDisplayed());
    }
}