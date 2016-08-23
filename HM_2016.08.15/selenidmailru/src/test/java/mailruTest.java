import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Lenovo on 8/16/2016.
 */
public class mailruTest {

    @Test
    public void sendlettersfromStrongzubovich(){
        String login="strong.zubovich@bk.ru";
        String password="ZXCvbn123!";
        String recipient="nemanskaja@mail.ru";

        LoginPage.login(login, password);
        SendLetter.send(recipient);
    }

    @Test
    public void countlettersonMybox(){
        String login="nemanskaja@mail.ru";
        String password="avtotest08082016";

        LoginPage.login(login, password);
        CountLetters.count();
    }

    @Test
    public void loadAvatarAvatar(){
        String login="nemanskaja@mail.ru";
        String password="avtotest08082016";

        LoginPage.login(login, password);
        Avatar.uploadavatar();
    }
}
