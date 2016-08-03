import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Lenovo on 8/3/2016.
 */
public class LetterPage {
    WebDriver driver;
    By count = By.className("b-datalist__item__panel");

    public LetterPage(WebDriver driver){
        this.driver = driver;
    }

    //count letters
    public void countletters(){
        List<WebElement> numberOfCheckBox = driver.findElements(count);
        int numberOfLetters = numberOfCheckBox.size();
        System.out.println("There are " + numberOfLetters + " letters in a Box");

        int letters;
        while (true) {
            letters = driver.findElements(By.cssSelector("div.b-datalist__item__panel")).size();
            System.out.println("letters " + letters);
            if (!driver.findElement(By.cssSelector("div[data-name='next']")).getAttribute("class").contains("b-toolbar__btn_disabled")) {
                driver.findElement(By.cssSelector("i.ico_toolbar_arrow_right")).click();
            } else {
                break;
            }
        }
    }

}
