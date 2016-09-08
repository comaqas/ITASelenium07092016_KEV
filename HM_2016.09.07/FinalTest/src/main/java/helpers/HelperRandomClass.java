package helpers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 8/30/2016.
 */
public class HelperRandomClass {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(20);
    }

    public static String getRandomEmail() {
        return UUID.randomUUID().toString().substring(20) + "@mail.ru";
    }

    public static String getRandomSubject() {
        return getRandomString() + "\\" + new Date().toString().replaceAll(" ", "").replaceAll(":", "");
    }


    public static String getRandomAdress() {
        return getRandomString() + "-" + (Math.random() * 150 + 1) + "-" + (Math.random() * 200 + 1);
    }

    public static String getTelephone() {
        return RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(3) + "-" + RandomStringUtils.randomNumeric(4);

    }

    public static String getName() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String getSurname() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static String getZip() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String getAlias() {
        return RandomStringUtils.randomNumeric(3);
    }




    public static void setSelect(WebElement element) {
        Select dropdown = new Select(element);
        List<WebElement> selectOptions = dropdown.getOptions();
        int maxSize = selectOptions.size() - 1;
        int randomState = (int) (Math.random() * (maxSize - 1) + 1);
        dropdown.selectByIndex(randomState);

    }

    /*
    public static String getBirthYear() {
        int randomValue = (int) (Math.random() * 116 + 1900);
        String randomYear = String.valueOf(randomValue);
        return randomYear;
    }

    public static String getBirthDate() {
        int randomValue = (int) (Math.random() * 28 + 1);
        String randomDay = String.valueOf(randomValue);
        return randomDay;
    }

    public static String getBirthMonth() {
        int randomMonth = (int) (Math.random() * 12 + 1);
        String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return month[randomMonth];
    }

    public static void setState(WebElement element) {
        Select dropdown = new Select(element);
        int randomState = (int) (Math.random() * (50 - 1) + 1);
        dropdown.selectByIndex(randomState);
    }
*/

}
