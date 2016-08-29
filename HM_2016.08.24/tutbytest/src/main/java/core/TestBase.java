package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 8/25/2016.
 */
public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://mail.tut.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

      @AfterTest
        public void teardown() {
            driver.quit();
        }
}
