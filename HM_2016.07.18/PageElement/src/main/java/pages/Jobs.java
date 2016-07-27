package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 7/27/2016.
 */
public class Jobs {

    private static final By SEARCHJOBS = By.cssSelector(".column-left");

    public static void assertJobs(WebDriver driver){
        WebElement searchjobs = driver.findElement(SEARCHJOBS);
        Assert.assertTrue(searchjobs.isDisplayed(), "not found searchjobs");
    }
}
