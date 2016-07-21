package statictest;

import org.testng.annotations.Test;

import pages.MailStatic;


/**
 * Created by Lenovo on 19.07.2016.
 */
public class StaticPOTest{
    static String username = "";
    static String password="ZXCvbn123!";

    @Test
    public void coutnTest() {
        username = "strong.zubovich@bk.ru";
        MailStatic.typeUsername(username);
        MailStatic.typePassword(password);
        MailStatic.avtorization();
        MailStatic.countletters();

    }
}
