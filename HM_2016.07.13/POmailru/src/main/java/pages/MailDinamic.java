package pages;
import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lenovo on 19.07.2016.
 */
public class MailDinamic extends TestBase {

    private static final By PAGE_URL = By.name("https://mail.ru/");

    private WebDriver driver;

    public MailDinamic(WebDriver driver) {
        this.driver = driver;
    }



    public static void searchFor(WebDriver driver) {
        MailStatic page = new MailStatic();
        MailStatic.getBrowser();
    }

    public MailDinamic typeUsername(String username) {
        driver.findElement(By.cssSelector("#mailbox__login"));
        return this;
    }

    public MailDinamic typePassword(String password) {
        driver.findElement(By.cssSelector("#mailbox__password"));
        return this;
    }

    public MailDinamic avtorization() {
        driver.findElement(By.cssSelector("#mailbox__auth__button")).click();
        return new MailDinamic(driver);
    }

    public int countletters() {
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        return numberOfCheckBox.size();


    }
}