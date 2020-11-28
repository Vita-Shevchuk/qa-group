import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GameTesting {
    private WebDriver driver;

    @BeforeClass

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "src/main/java/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.get ("https://flukeout.github.io/");
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void letsPlay(){
        System.out.println("I'm gonna play the game: "+driver.getTitle());
        System.out.println("===================================");
        //define some locators for game
        WebElement currentGameTask = driver.findElement(By.className("order"));
        WebElement gameLevel= driver.findElement(By.className("level-text"));
        WebElement rowForAnswer = driver.findElement(By.xpath("//input[@class='input-strobe']"));
        WebElement enterButton = driver.findElement(By.xpath("//div[contains (@class, 'enter-button') and contains (text(), 'enter')]"));

        //define an explicit wait
        WebDriverWait waitBeforeAnswer = (new WebDriverWait(driver, 10));
        WebDriverWait waitAfterTest = (new WebDriverWait(driver, 10));

        // Let's play 1st level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 2 of 32"));
        if (gameLevel.getText().equals("Level 2 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 2nd level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 3 of 32"));
        if (gameLevel.getText().equals("Level 3 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 3rd level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("#fancy");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 4 of 32"));
        if (gameLevel.getText().equals("Level 4 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 4th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate apple");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 5 of 32"));
        if (gameLevel.getText().equals("Level 5 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 5th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("#fancy pickle");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 6 of 32"));
        if (gameLevel.getText().equals("Level 6 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 6th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys(".small");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 7 of 32"));
        if (gameLevel.getText().equals("Level 7 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 7th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("orange.small");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 8 of 32"));
        if (gameLevel.getText().equals("Level 8 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 8th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento orange.small");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 9 of 32"));
        if (gameLevel.getText().equals("Level 9 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 9th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate, bento");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 10 of 32"));
        if (gameLevel.getText().equals("Level 10 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 10th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("*");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 11 of 32"));
        if (gameLevel.getText().equals("Level 11 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 11th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate *");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 12 of 32"));
        if (gameLevel.getText().equals("Level 12 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 12th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate + apple");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 13 of 32"));
        if (gameLevel.getText().equals("Level 13 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 13th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento ~ pickle");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 14 of 32"));
        if (gameLevel.getText().equals("Level 14 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 14th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate>apple");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 15 of 32"));
        if (gameLevel.getText().equals("Level 15 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 15th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("orange:first-child");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 16 of 32"));
        if (gameLevel.getText().equals("Level 16 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 16th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate apple:only-child, plate pickle:only-child");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 17 of 32"));
        if (gameLevel.getText().equals("Level 17 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 17th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("apple, pickle");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 18 of 32"));
        if (gameLevel.getText().equals("Level 18 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 18th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate:nth-child(3)");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 19 of 32"));
        if (gameLevel.getText().equals("Level 19 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 19th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento:nth-last-child(3)");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 20 of 32"));
        if (gameLevel.getText().equals("Level 20 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 20th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("apple:first-of-type");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 21 of 32"));
        if (gameLevel.getText().equals("Level 21 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 21st level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate:nth-of-type(even)");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 22 of 32"));
        if (gameLevel.getText().equals("Level 22 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 22nd level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate:nth-of-type(2n+3)");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 23 of 32"));
        if (gameLevel.getText().equals("Level 23 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 23rd level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("apple:only-of-type");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 24 of 32"));
        if (gameLevel.getText().equals("Level 24 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 24th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("apple:last-of-type, orange:last-of-type");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 25 of 32"));
        if (gameLevel.getText().equals("Level 25 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 25th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento:empty");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 26 of 32"));
        if (gameLevel.getText().equals("Level 26 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 26th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("apple:not(.small)");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 27 of 32"));
        if (gameLevel.getText().equals("Level 27 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 27th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("[for]");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 28 of 32"));
        if (gameLevel.getText().equals("Level 28 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 28th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("plate[for]");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 29 of 32"));
        if (gameLevel.getText().equals("Level 29 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 29th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("bento[for='Vitaly']");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 30 of 32"));
        if (gameLevel.getText().equals("Level 30 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 30th level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("[for^='Sa']");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 31 of 32"));
        if (gameLevel.getText().equals("Level 31 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 31st level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("[for$='ato']");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 32 of 32"));
        if (gameLevel.getText().equals("Level 32 of 32")) {
            System.out.println("Correct");
        } else{
            System.out.println("Wrong answer");
        }

        // Let's play 32nd level
        System.out.println("I am on " + gameLevel.getText());
        System.out.println("My task is " + currentGameTask.getText());
        waitBeforeAnswer.until(ExpectedConditions.elementToBeClickable(rowForAnswer));
        rowForAnswer.sendKeys("[for*='obb']");
        enterButton.click();
        waitAfterTest.until(ExpectedConditions.textToBe(By.className("level-text"), "Level 32 of 32"));

        WebElement winner = driver.findElement(By.className("winner"));

        if (gameLevel.getText().equals("Level 32 of 32"))
            System.out.println(winner.getText());
         else
            System.out.println("Wrong answer");



        System.out.println("======================================================");



    }

}
