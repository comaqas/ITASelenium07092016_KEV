package dinamictest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.MailDinamic;
import pages.MailStatic;

import static org.testng.Assert.assertTrue;

/**
 * Created by Lenovo on 19.07.2016.
 */
public class DinamicPOTest extends MailStatic{

    @Test
    public void coutnTest() {
        MailDinamic page = new MailDinamic(driver);

        String username="strong.zubovich@bk.ru";
        typeUsername(username);
        String password="ZXCvbn123!";
        typePassword(password);
        avtorization();
        countletters();

    }
}
