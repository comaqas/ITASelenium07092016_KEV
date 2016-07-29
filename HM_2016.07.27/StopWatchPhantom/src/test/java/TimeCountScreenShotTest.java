import org.apache.commons.lang.time.StopWatch;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 7/28/2016.
 */
public class TimeCountScreenShotTest {
    WebDriver driver;
    String email = "strong.zubovich@bk.ru";
    String password = "ZXCvbn123!";

//!!! I couldn't take screenshot!!!

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void mailPostTest() {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        driver.get("https://mail.ru/");
        //public ScreenShotDifferRule screenShotDiffer = new ScreenShotDifferRule(driver);
        //BufferedImage originScreenShot = screenShotDiffer.takeOriginScreenShot(//mail.ru/);

        //set login
        WebElement LoginField = driver.findElement(By.cssSelector("#mailbox__login"));
        LoginField.sendKeys(email);
        //set password
        WebElement PasswordField = driver.findElement(By.cssSelector("#mailbox__password"));
        PasswordField.sendKeys(password);

        stopWatch.split();
        System.out.println("Stopwatch split time: " + stopWatch.toSplitString());
        stopWatch.stop();
        System.out.println("Stopwatch time: " + stopWatch);


        //autorization
        WebElement Autorization = driver.findElement(By.cssSelector("#mailbox__auth__button"));
        Autorization.click();

        stopWatch.reset();
        stopWatch.start();

        //count letters
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        int numberOfLetters = numberOfCheckBox.size();
        System.out.println("There are " + numberOfLetters + " letters in a Box");

        sleep();

        int letters;
        while (true) {
            letters = driver.findElements(By.cssSelector("div.b-datalist__item__panel")).size();
            System.out.println("letters " + letters);
            if (!driver.findElement(By.cssSelector("div[data-name='next']")).getAttribute("class").contains("b-toolbar__btn_disabled")) {
                driver.findElement(By.cssSelector("i.ico_toolbar_arrow_right")).click();
            } else {
                break;
            }
        }

        System.out.println("Stopwatch time: " + stopWatch);


    }

    public static void sleep() {
        System.out.println("1 second goes by");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
