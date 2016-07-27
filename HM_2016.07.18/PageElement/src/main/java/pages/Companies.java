package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 7/27/2016.
 */
public class Companies {

    private static final By ISSOFT = By.cssSelector("[href = '/issoft']");

    public static void assertCompanies(WebDriver driver){
        WebElement issoft = driver.findElement(ISSOFT);
        Assert.assertTrue(issoft.isDisplayed(), "not found issoft");
    }
}
