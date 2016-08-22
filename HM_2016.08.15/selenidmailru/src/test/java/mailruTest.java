import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
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

        LoginPage.login(login, password);

        $(By.xpath("//*[@id=\"b-toolbar__left\"]/div/div/div[2]/div/a/span")).click();
        $(By.cssSelector(".js-row-To textarea.js-input")).setValue("nemanskaja@mail.ru");
        $(By.cssSelector(".js-row-Subject input")).setValue(HelperRandomClass.getRandomString());
        $(By.cssSelector(".mceAction.mce_emotions[href=\"javascript:;\"]")).click();
        $(By.cssSelector(".emoji[src=\"https://img.imgsmail.ru/emoji/1f600.svg\"]")).click();
/*
        switchTo().innerFrame("compose_2451_composeEditor_ifr");
        $(By.id("tinymce")).setValue("Hello");
        switchTo().defaultContent();
*/
        $(By.cssSelector("[data-name=\"send\"]")).click();
    }

    @Test
    public void countlettersonMybox(){
        String login="nemanskaja@mail.ru";
        String password="avtotest08082016";

        LoginPage.login(login, password);

        $(By.className("b-datalist__item__panel")).click();
        System.out.println($$(By.cssSelector("div.b-datalist__item__panel")).size());

        int letters =0;
        while (true){
            int tempLetters = $$(By.cssSelector("div.b-datalist__item__panel")).size();
            System.out.println("tempLetters "+ tempLetters);
            letters = letters+tempLetters;
            if($(By.cssSelector("div[data-name='next']")).is(Condition.exist) &&
                    !$(By.cssSelector("div[data-name='next']")).is(Condition.cssClass("b-toolbar__btn_disabled"))){
                $(By.cssSelector("i.ico_toolbar_arrow_right")).click();
                System.out.println("all letters "+letters);
            }else {
                break;
            }
        }
        System.out.println("all letters "+letters);
    }

    @Test
    public void loadAvatarAvatar(){
        String login="nemanskaja@mail.ru";
        String password="avtotest08082016";

        LoginPage.login(login, password);

        $(By.id("PH_user-email")).click();
        $(By.cssSelector("[href=\"https://e.mail.ru/settings/userinfo\"]")).click();
        $(By.cssSelector(".js-upload.form__button_upload")).uploadFile(new File("C:\\!myown\\Lena\\automatization\\selenidmailru\\cat.jpg"));
        $(By.cssSelector("[data-fire=\"save\"]")).click();

    }
}
