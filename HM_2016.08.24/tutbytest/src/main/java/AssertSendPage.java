import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 8/10/2016.
 */
public class AssertSendPage {
    public static final By SEND_LINK = Locators.get("SendLink");

    public static final By CONFIRMATION_SEND_LETTER = Locators.get("Confirmationsendletter");

    public static void assertsendletter(WebDriver driver, String expectedSubject) throws InterruptedException {
        Thread.sleep(5000);
        WebElement sendedbutton = driver.findElement(SEND_LINK);
        sendedbutton.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElements(CONFIRMATION_SEND_LETTER).get(0).getText(), expectedSubject);


    }

}
