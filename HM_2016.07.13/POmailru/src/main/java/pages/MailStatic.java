package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lenovo on 19.07.2016.
 */
public class MailStatic extends TestBase {

    private static final By PAGE_URL = By.name("https://mail.ru/");



    public static void searchFor(WebDriver driver) {
        MailStatic page = new MailStatic();
        MailStatic.getBrowser();
    }

    public static void typeUsername(String username) {
        driver.findElement(By.cssSelector("#mailbox__login")).sendKeys(username);
    }

    public static void typePassword(String password) {
        driver.findElement(By.cssSelector("#mailbox__password"));
    }

    public static void avtorization() {
        driver.findElement(By.cssSelector("#mailbox__auth__button")).click();
    }

    public static int countletters() {
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        return numberOfCheckBox.size();


    }
}
