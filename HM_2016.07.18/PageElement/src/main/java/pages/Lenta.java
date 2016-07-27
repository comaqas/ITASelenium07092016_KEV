package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 * Created by Lenovo on 7/27/2016.
 */
public class Lenta {

    private static final By DEVBY = By.cssSelector(".header-logo");

    public static void assertLenta(WebDriver driver){
        WebElement devby = driver.findElement(DEVBY);
        Assert.assertTrue(devby.isDisplayed(), "not found logo");
    }

}
