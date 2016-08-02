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
 * Created by Lenovo on 8/1/2016.
 */
public class DinamicTest{
    protected static WebDriver driver;

    @BeforeTest
    public static void getBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
    }

    @Test
            public void dinamictestmail(){
        DinamicPage page = new DinamicPage(driver);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";
        page.login(email, password);

        //count letters
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        int numberOfLetters = numberOfCheckBox.size();
        System.out.println("There are " + numberOfLetters + " letters in a Box");

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

    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
