package pages;

import helpers.HelperRandomClass;
import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Lenovo on 8/30/2016.
 */
public class CreateAccount {

    public static final By CREATE_ACCOUNT_EMAIL = Locators.get("CreateAccountEmail");
    public static final By CREATE_ACCOUNT_BUTTON = Locators.get("CreateAccountButton");

    public static final By GENDER_MRS = Locators.get("GenderMrs");
    public static final By FIRST_NAME = Locators.get("FirstName");
    public static final By LAST_NAME = Locators.get("LastName");
    public static final By PASSWORD = Locators.get("Password");
    public static final By DATE_BIRTH_DAY = Locators.get("DateOfBirthDay");
    public static final By DATE_BIRTH_MONTH = Locators.get("DateOfBirthMonth");
    public static final By DATE_BIRTH_YEAR = Locators.get("DateOfBirthYear");
    public static final By YOURADDRESS_COMPANY = Locators.get("YourAddressCompany");
    public static final By YOURADDRESS_ADDRESS = Locators.get("YourAddressAddress");
    public static final By YOURADDRESS_ADDRESS2 = Locators.get("YourAddressAddress2");
    public static final By YOURADDRESS_CITY = Locators.get("YourAddressCity");
    public static final By YOURADDRESS_STATE = Locators.get("YourAddressState");
    public static final By YOURADDRESS_ZIP = Locators.get("YourAddressZip");
    public static final By YOURADDRESS_ADDITIONAL_INFORMATION = Locators.get("YourAddressAdditionalInformation");
    public static final By YOURADDRESS_HOME_PHONE = Locators.get("YourAddressHomePhone");
    public static final By YOURADDRESS_MOBILE_PHONE = Locators.get("YourAddressMobilePhone");
    public static final By YOURADDRESS_ALIAS = Locators.get("YourAddressAlias");
    public static final By REGISTERED_BUTTON = Locators.get("RegisteredButton");

    public static void EnterEmail(WebDriver driver) {

        driver.findElement(CREATE_ACCOUNT_EMAIL).sendKeys(HelperRandomClass.getRandomEmail());
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();

    }

    public static void FillOutRegistryForm(WebDriver driver) {

        driver.findElement(GENDER_MRS).click();
        driver.findElement(FIRST_NAME).sendKeys(HelperRandomClass.getName());
        driver.findElement(LAST_NAME).sendKeys(HelperRandomClass.getSurname());
        driver.findElement(PASSWORD).sendKeys(HelperRandomClass.getRandomString());
        //driver.findElement(DATE_BIRTH_DAY).sendKeys(HelperRandomClass.getBirthDate());
        //driver.findElement(DATE_BIRTH_MONTH).sendKeys(HelperRandomClass.getBirthMonth());
        //driver.findElement(DATE_BIRTH_YEAR).sendKeys(HelperRandomClass.getBirthYear());
        HelperRandomClass.setSelect(driver.findElement(DATE_BIRTH_DAY));
        HelperRandomClass.setSelect(driver.findElement(DATE_BIRTH_MONTH));
        HelperRandomClass.setSelect(driver.findElement(DATE_BIRTH_YEAR));
        driver.findElement(YOURADDRESS_COMPANY).sendKeys(HelperRandomClass.getRandomString());
        driver.findElement(YOURADDRESS_ADDRESS).sendKeys(HelperRandomClass.getRandomAdress());
        driver.findElement(YOURADDRESS_ADDRESS2).sendKeys(HelperRandomClass.getRandomAdress());
        driver.findElement(YOURADDRESS_CITY).sendKeys(HelperRandomClass.getRandomString());
        //HelperRandomClass.setState(driver.findElement(YOURADDRESS_STATE));
        HelperRandomClass.setSelect(driver.findElement(YOURADDRESS_STATE));
        driver.findElement(YOURADDRESS_ZIP).sendKeys(HelperRandomClass.getZip());
        driver.findElement(YOURADDRESS_ADDITIONAL_INFORMATION).sendKeys(HelperRandomClass.getRandomSubject());
        driver.findElement(YOURADDRESS_HOME_PHONE).sendKeys(HelperRandomClass.getTelephone());
        driver.findElement(YOURADDRESS_MOBILE_PHONE).sendKeys(HelperRandomClass.getTelephone());
        driver.findElement(YOURADDRESS_ALIAS).sendKeys(HelperRandomClass.getAlias());
        driver.findElement(REGISTERED_BUTTON).click();

    }
}
