import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 8/9/2016.
 */
public class SendPage {
    public static final By WHOM_LINK = Locators.get("WhomLink");
    public static final By TOPIC_LINK = Locators.get("TopicLink");
    public static final By BODY_TEXT_MAIL = Locators.get("BodyTextMail");
    public static final By SEND_LETTER = Locators.get("Send");

    public static void sentletter(WebDriver driver, String recipient, String Subject) {

        WebElement emailfield = driver.findElement(WHOM_LINK);
        emailfield.sendKeys(recipient);

        WebElement passwordfield = driver.findElement(TOPIC_LINK);
        passwordfield.sendKeys(Subject);

        WebElement textbody = driver.findElement(BODY_TEXT_MAIL);
        textbody.sendKeys("Test");

        WebElement clickbutton = driver.findElement(SEND_LETTER);
        clickbutton.click();
    }

}
