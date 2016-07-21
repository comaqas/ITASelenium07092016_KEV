package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;


/**
 * Created by Lenovo on 19.07.2016.
 */
public class TestBase {

    protected static WebDriver driver;

    @BeforeTest
    public static void getBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void teardown() {

        driver.quit();
    }

}
