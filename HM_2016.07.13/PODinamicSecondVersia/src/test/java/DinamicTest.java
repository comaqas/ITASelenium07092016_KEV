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
        LoginPage page = new LoginPage(driver);

        String email = "strong.zubovich@bk.ru";
        String password = "ZXCvbn123!";
        page.login(email, password);

        LetterPage countpage = new LetterPage(driver);
        countpage.countletters();



    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
