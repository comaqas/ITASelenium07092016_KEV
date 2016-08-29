import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Lenovo on 8/24/2016.
 */
public class webstorageTest {

    private WebDriver driver;


    @Test
    public void testHTML5LocalStorage() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://cookbook.seleniumacademy.com/html5storage.html");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
// Get the current value of localStorage.lastname, this should be Smith
        String lastName = (String) jsExecutor
                .executeScript("return localStorage.getItem('lastname');");
        jsExecutor.executeScript("localStorage.setItem('lastname', 'Elena');");//change lastname
        String updatedLastName = (String) jsExecutor.executeScript("return localStorage.getItem('lastname');");

        String colorSetting = (String) jsExecutor.executeScript("return localStorage.colorSetting;");//doesn't use in most of sites
        jsExecutor.executeScript("localStorage.setItem('colorSetting', 'white');");

        String updatedColorSetting = (String) jsExecutor.executeScript("return localStorage.colorSetting;");

        System.out.println("colorSetting: " + colorSetting);
        System.out.println("updatedColorSetting: " + updatedColorSetting);


        //assertEquals(updatedLastName, lastName);//test fall
    }

    @Test
    public void testHTML5SessionStorage(){
        driver = new FirefoxDriver();
        driver.get("http://cookbook.seleniumacademy.com/html5storage.html");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement button = driver.findElement(By.id("click"));
        WebElement field = driver.findElement(By.id("clicks"));

        String clickCount = (String)jsExecutor.executeScript("return sessionStorage.clickcount;");
        String clickValue = field.getAttribute("value");

        button.click();
        String updatedclickCount = (String)jsExecutor.executeScript("return sessionStorage.clickcount;");
        String updatedclickValue = field.getAttribute("value");

        System.out.println("click count before: " + clickCount + " after: " + updatedclickCount);
        System.out.println("field value before: " + clickValue + " after: " +updatedclickValue);

    }

    @Test
    public void getPageLoadTimeTest(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.tut.by");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //Получаем время Load Event End (окончание загрузки страниы)
        long loadEventEnd = (Long) jsExecutor.executeScript("return window.performance.timing.loadEventEnd;");
        // Получаем Navigation Event Start (начало перехода)
        long navigationStart = (Long) jsExecutor.executeScript("return window.performance.timing.navigationStart;");
        // Разница между Load Event End и Navigation Event Start - это время загрузки страницы
        System.out.println("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
        driver.quit();
    }}



