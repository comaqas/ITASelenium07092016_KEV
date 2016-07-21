package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertTrue;
/**
 * Created by Lenovo on 19.07.2016.
 */
public class MailFactory extends TestBase{

    @FindBy(css = "#mailbox__login")
    private WebElement typeUsername;

    @FindBy(css = "#mailbox__password")
    private WebElement typePassword;

    @FindBy(css = "#mailbox__auth__button")
    private WebElement avtorization;

    @FindBy(name = "b-datalist__item__panel")
    private List<WebElement> countletters;


    public MailFactory (WebDriver driver) {
        this.driver = driver;
    }


    public static void searchFor(WebDriver driver) {
        MailStatic page = new MailStatic();
        MailStatic.getBrowser();
    }

    public void typeUsername(String username) {
        typeUsername.sendKeys("strong.zubovich@bk.ru");
    }


    public void typePassword(String password) {
        typePassword.sendKeys("ZXCvbn123!");
    }


    public void avtorization() {
        avtorization.click();
    }


    public int countletters() {
        return countletters.size();


    }
}
