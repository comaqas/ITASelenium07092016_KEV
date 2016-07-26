import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

/**
 * Created by Lenovo on 7/26/2016.
 */
public class MailruTest {
    WebDriver driver;
    String email = "strong.zubovich@bk.ru";
    String password = "ZXCvbn123!";

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void mailPostTest() {

        driver.get("https://mail.ru/");

        //set login
        WebElement LoginField = driver.findElement(By.cssSelector("#mailbox__login"));
        LoginField.sendKeys(email);
        //set password
        WebElement PasswordField = driver.findElement(By.cssSelector("#mailbox__password"));
        PasswordField.sendKeys(password);
        //autorization
        WebElement Autorization = driver.findElement(By.cssSelector("#mailbox__auth__button"));
        Autorization.click();
        //count letters
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        int numberOfLetters = numberOfCheckBox.size();
        System.out.println("There are " + numberOfLetters + " letters in a Box");

        int letters;
        while (true) {
            letters = driver.findElements(By.cssSelector("div.b-datalist__item__panel")).size();
            System.out.println("letters " + letters);
            if (!driver.findElement(By.cssSelector("div[data-name='next']")).getAttribute("class").contains("b-toolbar__btn_disabled")) {
                driver.findElement(By.cssSelector("i.ico_toolbar_arrow_right")).click();
            } else {
                break;
            }
        }


    }
}
