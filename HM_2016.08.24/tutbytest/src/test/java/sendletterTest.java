import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.security.auth.Subject;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lenovo on 8/8/2016.
 */
public class sendletterTest {

    protected WebDriver driver;


    @Test
    public void ProjectTutByTest() {
        driver = new FirefoxDriver();
        driver.get("https://mail.tut.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String email = "nemanskaja39";
        String password = "avtotest_08082016";
        String Subject = HelperRandomClass.getRandomString();

        LoginPage.login(driver, email, password);

        LetterPage.write(driver);

        String recipient = "nemanskaja39@tut.by";
        SendPage.sentletter(driver, recipient, Subject);

        AssertSendPage.assertsendletter(driver, Subject);

        driver.quit();
    }

    @Test
    public void SecondTutByTest() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://mail.tut.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String email = "nemanskaja39";
        String password = "avtotest_08082016";
        String Subject = HelperRandomClass.getRandomSubject();

        LoginPage.login(driver, email, password);
        LetterPage.write(driver);

        String recipient = "nemanskaja39_2@tut.by";
        SendPage.sentletter(driver, recipient, Subject);

        ExitPage.exitstatus(driver);

        driver.quit();
    }

    @Test
    public void ThirtTutByTest(){
        driver = new FirefoxDriver();
        driver.get("https://mail.tut.by/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String email2 = "nemanskaja39_2";
        String password2 = "avtotest_24082016";
        String Subject = HelperRandomClass.getRandomString();

        LoginPage.login(driver, email2, password2);

        AssertEntrancePage.assertsendletter(driver, Subject);

        driver.quit();

    }
}


