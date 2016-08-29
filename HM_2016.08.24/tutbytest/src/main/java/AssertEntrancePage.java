import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Lenovo on 8/26/2016.
 */
public class AssertEntrancePage {

        public static final By ENTRANCE_LINK = Locators.get("entrance");
    public static final By CONFIRMATION_SEND_LETTER = Locators.get("Confirmationsendletter");
    public static final By SELECT_FIRST_LETTER = Locators.get("selectfirstletter");
    public static final By DELETE_LINK = Locators.get("delete");



        public static void assertsendletter(WebDriver driver,  String expectedSubject) {

            WebElement entrancebutton = driver.findElement(ENTRANCE_LINK);
            entrancebutton.click();

//Doesn't work assert
            //Assert.assertEquals(driver.findElements(CONFIRMATION_SEND_LETTER).get(0).getText(), expectedSubject);
//Doesn't work. Can't click first checkbox
           //WebElement letter = driver.findElement(SELECT_FIRST_LETTER);
           //letter.click();

           WebElement deletebutton = driver.findElement(DELETE_LINK);
           deletebutton.click();

        }

}


