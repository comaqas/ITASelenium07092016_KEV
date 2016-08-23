import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lenovo on 8/23/2016.
 */
public class Avatar {
    public static void uploadavatar(){

        $(Locators.get("UserInformation")).click();
        $(Locators.get("OwnData")).click();
        $(Locators.get("UploadFoto")).uploadFile(new File("C:\\!myown\\Lena\\automatization\\selenidmailru\\cat.jpg"));
        $(Locators.get("SaveFoto")).click();
        //Assert.assertEquals("not found foto", "https://filin.mail.ru/pic?width=180&height=180&email=nemanskaja%40mail.ru&name=Elena%20Kasd&version=4&build=7");

    }
}
