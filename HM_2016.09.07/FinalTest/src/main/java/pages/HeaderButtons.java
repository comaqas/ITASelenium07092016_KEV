package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 8/29/2016.
 */
public class HeaderButtons {

    public static final By CONTACT_US = Locators.get("ContactUsButton");
    public static final By LOGIN = Locators.get("LoginButton");

    public static void clickContactUs(WebDriver driver){

       WebElement buttoncontactus = driver.findElement(CONTACT_US);
        buttoncontactus.click();
    }

    public static void clickSignIn(WebDriver driver){

        WebElement buttonlogin = driver.findElement(LOGIN);
        buttonlogin.click();
    }

}