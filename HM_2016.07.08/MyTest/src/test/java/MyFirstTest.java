/**
 * Created by Lenovo on 08.07.2016.
 */

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyFirstTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); //open on all window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void myTestMethod() throws InterruptedException {

        //driver.get("https://www.tut.by");
        //driver.get("http://catalog.onliner.by/mobile");
        driver.get("https://www.onliner.by");

        //Open catalog
        WebElement catalogButton = driver.findElement(By.cssSelector("[href='http://catalog.onliner.by/']>.b-main-navigation__text"));
        catalogButton.click();
        assertEquals(driver.getTitle(), "Каталог Onliner.by");

        //Open electronica
        WebElement ElectronicaButton = driver.findElement(By.xpath("//*[text()='Электроника']/.."));
        ElectronicaButton.click();

        //Open mobile
        WebElement MobileButton = driver.findElement(By.cssSelector(".catalog-navigation-list__link-inner > [href='http://catalog.onliner.by/mobile']"));
        MobileButton.click();

        //Select production
        WebElement ModelCheckBox = driver.findElement(By.cssSelector("#schema-filter  div.schema-filter__facet ul > li > label > span.i-checkbox > [value='meizu']"));
        ModelCheckBox.click();

        //set the price range
        WebElement PriceText = driver.findElement(By.cssSelector("#schema-filter div.schema-filter__group > div:nth-child(1) > input.schema-filter-control__item.schema-filter__number-input.schema-filter__number-input_price"));
        PriceText.sendKeys("400");
        WebElement PriceTextUntil = driver.findElement(By.cssSelector("#schema-filter div.schema-filter__group > div:nth-child(2) > input.schema-filter-control__item.schema-filter__number-input.schema-filter__number-input_price"));
        PriceTextUntil.sendKeys("470");


        //Select production year, it's doesn't work!!!

        // WebElement YearCheckBox = driver.findElement(By.cssSelector("#schema-filter > div:nth-child(1) > div:nth-child(3) > div.schema-filter__facet > ul > li:nth-child(1) > label > input"));
        //YearCheckBox.click();
        //driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        //Select the RAM range
        WebElement OzyCheckBox = driver.findElement(By.cssSelector("#schema-filter > div:nth-child(1) > div:nth-child(8) > div.schema-filter__facet > div > div:nth-child(1) > input"));
        OzyCheckBox.sendKeys("3");

        Thread.sleep(1000);

        //check expected and actual result, it's doesn't work: can not find a real result clearly!!!
        String ActualResultText = driver.findElement(By.cssSelector("[data-bind='html: product.full_name']")).getText();

        assertEquals(ActualResultText, "MEIZU M3 32GB White");
    }

    @Test
    public void doubleClickTest() {

        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement square = driver.findElement(By.tagName("div"));
        String colorValue = square.getCssValue("background-color");

        assertEquals(colorValue, "rgba(0, 0, 255, 1)");

        Actions builder = new Actions(driver);
        builder.click().pause(100).click().perform();

        colorValue = square.getCssValue("background-color");
        assertEquals(colorValue, "rgba(255, 255, 0, 1)");


    }

    @Test
    public void dragDropTest() {


        driver.get("http://code.makery.ch/library/dart-drag-and-drop");
        driver.switchTo().frame(0);

        List<WebElement> allDocuments = driver.findElements(By.className("document"));
        assertEquals(allDocuments.size(), 4);//list size

        //work with dropdown menu
        WebElement document = driver.findElement(By.className("document"));
        WebElement trash = driver.findElement(By.cssSelector(".trash")); //work if full

        Actions builder = new Actions(driver);
        builder.dragAndDrop(document, trash).perform();

        builder.keyDown(Keys.RETURN);

        allDocuments = driver.findElements(By.className("document"));

        assertEquals(allDocuments.size(), 3);
    }

    @Test
    public void mailPostTest() {

        driver.get("https://mail.ru/");
        //set login
        WebElement LoginField = driver.findElement(By.cssSelector("#mailbox__login"));
        LoginField.sendKeys("strong.zubovich@bk.ru");
        //set password
        WebElement PasswordField = driver.findElement(By.cssSelector("#mailbox__password"));
        PasswordField.sendKeys("ZXCvbn123!");
        //autorization
        WebElement Autorization = driver.findElement(By.cssSelector("#mailbox__auth__button"));
        Autorization.click();
        //count letters
        List<WebElement> numberOfCheckBox = driver.findElements(By.className("b-datalist__item__panel"));
        numberOfCheckBox.size();
        System.out.println("letter number" + numberOfCheckBox.size());


    }

    @Test
    public void multipleWindowsTest() {


        driver.get("https://the-internet.herokuapp.com/windows");

        String initialWindowHandle = driver.getWindowHandle();

        driver.findElement(By.cssSelector(".example [target='_blank")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        String secondWindowHandle="";

        //second variant
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(initialWindowHandle) && !windowHandle.equals(secondWindowHandle)) {
                driver.switchTo().window(windowHandle);//if not equal switchto first next window
            }
        }

        assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        //assertTrue(driver.findElement(By.tagName("h3")).getText() == "New Window");//not visible result

        driver.close();

        driver.switchTo().window(initialWindowHandle);//to initial window

        assertEquals(driver.findElement(By.cssSelector(".example [target='_blank")).getText(), "Click Here");


    }

    @Test
    public void alertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.cssSelector("[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();//selenium
        String alertText = alert.getText();
        assertEquals(alertText, "I am a JS Alert");

        alert.accept();//ok

        WebElement result = driver.findElement(By.id("result"));
        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();

        alert = driver.switchTo().alert();

        alert.accept();
        assertEquals(result.getText(), "You clicked: Ok");

        driver.findElement(By.cssSelector("[onclick='jsConfirm()']")).click();
        alert = driver.switchTo().alert();//selenium
        alert.dismiss();
        assertEquals(result.getText(), "You clicked: Cancel");

        WebElement promptButton = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        String inputText = "text";

        promptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.accept();
        assertEquals(result.getText(), "You entered: " + inputText);

        promptButton.click();
        alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.dismiss();
        assertEquals(result.getText(), "You entered: null");

    }

    

}
