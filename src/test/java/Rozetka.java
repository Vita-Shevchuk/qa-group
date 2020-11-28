import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Rozetka {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }
    @AfterTest
    public void tearDown(){

        driver.quit();
    }

    @Test (description = "get page elements to click, matches and extracts")
    public void findElements() {
        WebElement searchField = driver.findElement(By.xpath("//input[@name='search']"));
        // 1. Check the text presence on the page
        String mainPageSource = driver.getPageSource();
        Assert.assertTrue(mainPageSource.contains(" Доставка по всей Украине"));

        //2. check the button
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='menu-toggler__text']")).getText(), "Каталог товаров");

        //3 check location of an element
        //System.out.println(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation());
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='menu-categories__link']/span")).getLocation().toString()
                , "(47, 144)");

        //4 check if an element is enabled
        Assert.assertTrue(searchField.isEnabled());
        Assert.assertFalse(!searchField.isEnabled());

        //5 check attribute value in placeholder
        Assert.assertEquals(searchField.getAttribute("placeholder"), "Я ищу...");
        Assert.assertNotEquals(searchField.getAttribute("placeholder"), "Я не ищу...");

        // 6 check the amount of elements om the page

        Assert.assertEquals(driver.findElements(By.xpath("//a[@class='menu-categories__link']/span")).size(), 17);

    }


}
