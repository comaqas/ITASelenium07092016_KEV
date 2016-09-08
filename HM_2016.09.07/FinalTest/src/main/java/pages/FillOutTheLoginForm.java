package pages;

import helpers.HelperRandomClass;
import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 8/30/2016.
 */
public class FillOutTheLoginForm {

    public static final By SUBJECT_HEADING = Locators.get("SubjectHeading");
    public static final By EMAIL_ADDRESS = Locators.get("EmailAdress");
    public static final By ORDER_REFERENCE = Locators.get("OrderReference");
    public static final By ATTACH_FILE = Locators.get("AttachFile");
    public static final By MESSAGE = Locators.get("Message");
    public static final By SEND = Locators.get("Send");


    public static void partOfEnter(WebDriver driver){
        driver.findElement(SUBJECT_HEADING).sendKeys("Customer service");
        driver.findElement(EMAIL_ADDRESS).sendKeys(HelperRandomClass.getRandomEmail());
        driver.findElement(ORDER_REFERENCE).sendKeys(HelperRandomClass.getRandomSubject());
        driver.findElement(ATTACH_FILE).sendKeys("C:\\!myown\\Lena\\automatization\\FinalTest\\dress.jpg");
    }


    public static void filloutAlldatas(WebDriver driver) {

        partOfEnter(driver);
        driver.findElement(MESSAGE).sendKeys(HelperRandomClass.getRandomString());
        driver.findElement(SEND).click();

    }

    public static void filloutWithoutMessageField(WebDriver driver) {

        partOfEnter(driver);
        driver.findElement(SEND).click();

    }
}
