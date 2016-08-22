import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Lenovo on 8/16/2016.
 */
public class LoginPage {

    public static   void login(String login, String password){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("selenide.browser", "chrome");
        Configuration.startMaximized = true;
        open("https://mail.ru/");
        $(Locators.get("LoginLink")).setValue(login);
        $(Locators.get("PasswordLink")).setValue(password)
                .pressEnter();
    }



}
