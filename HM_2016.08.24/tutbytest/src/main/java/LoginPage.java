import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 8/8/2016.
 */
public class LoginPage {

    public static final By LOGIN_LINK = Locators.get("LoginLink");
    public static final By PASSWORD_LINK = Locators.get("PasswordLink");
    public static final By LOGIN_BUTTON = Locators.get("LoginButton");


    public static void login(WebDriver driver, String email, String password) {

        WebElement emailfield = driver.findElement(LOGIN_LINK);
        emailfield.sendKeys(email);


        WebElement passwordfield = driver.findElement(PASSWORD_LINK);
        passwordfield.sendKeys(password);

        WebElement clickbutton = driver.findElement(LOGIN_BUTTON);
        clickbutton.click();
    }

}