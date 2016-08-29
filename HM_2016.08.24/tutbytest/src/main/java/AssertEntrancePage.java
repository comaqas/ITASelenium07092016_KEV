import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 8/26/2016.
 */
public class AssertEntrancePage {

        public static final By ENTRANCE_LINK = Locators.get("entrance");
    public static final By CONFIRMATION_INPUT_LETTER = Locators.get("inputLettersSubjects");
    public static final By SELECT_FIRST_LETTER = Locators.get("selectfirstletter");
    public static final By DELETE_LINK = Locators.get("delete");



        public static void assertsendletter(WebDriver driver,  String expectedSubject) throws InterruptedException {
            Thread.sleep(5000);
            WebElement entrancebutton = driver.findElement(ENTRANCE_LINK);
            entrancebutton.click();
            Thread.sleep(5000);
            String subjec = driver.findElements(CONFIRMATION_INPUT_LETTER).get(0).getText();
            Assert.assertEquals(driver.findElements(CONFIRMATION_INPUT_LETTER).get(0).getText(), expectedSubject);
            WebElement letter = driver.findElements(SELECT_FIRST_LETTER).get(0);
            letter.click();

            WebElement deletebutton = driver.findElement(DELETE_LINK);
            deletebutton.click();

        }

}


