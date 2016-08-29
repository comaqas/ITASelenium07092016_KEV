import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 8/26/2016.
 */
public class ExitPage {

    public static final By STATUS_LINK = Locators.get("statusdropbox");
    public static final By EXIT_LINK = Locators.get("exit");
    public static final By ASSERT_EXIT = Locators.get("assertexit");


    public static void exitstatus(WebDriver driver) throws InterruptedException {

        Thread.sleep(2000);
        WebElement emailfield = driver.findElement(STATUS_LINK);
        emailfield.click();

        Thread.sleep(2000);
        WebElement passwordfield = driver.findElement(EXIT_LINK);
        passwordfield.click();

        String mainPageTitle = "Белорусский портал TUT.BY";

        Assert.assertEquals(driver.getTitle(),mainPageTitle,"Error !!! Not Main Page Title !!! ");

    }
}
