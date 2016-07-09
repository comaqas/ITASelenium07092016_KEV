/**
 * Created by Lenovo on 08.07.2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class MyFirstTest {
    @Test
    public void myTestMethod() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize(); //open on all window

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        //check expected and actual result, it's doesn't work: can not find a real result clearly!!!
        WebElement ActualResultText = driver.findElement(By.cssSelector("#schema-products > div.schema-product__group > div > div.schema-product__part.schema-product__part_2 > div.schema-product__part.schema-product__part_4 > div.schema-product__title > a > span"));

        assertEquals(ActualResultText.getText(), "MEIZU M3 32GB White");


    }


}
