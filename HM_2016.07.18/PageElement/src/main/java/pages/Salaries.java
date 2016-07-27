package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 7/27/2016.
 */
public class Salaries {

    private static final By ITSALARY = By.cssSelector(".input.info-count");

    public static void assertSalaries(WebDriver driver){
        WebElement itsalary = driver.findElement(ITSALARY);
        Assert.assertTrue(itsalary.isDisplayed(), "not found itsalary");
    }
}
