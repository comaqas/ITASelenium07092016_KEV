package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SearchPage;

import static org.testng.Assert.assertEquals;

/**
 * Created by Lenovo on 20.07.2016.
 */
public class SearchTest {
    private WebDriver driver = new FirefoxDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @BeforeTest
    public void loadPage(){
        driver.get("https://dev.by/");
    }

    @Test
    public void SearchTest(){
        searchPage.clicklenta();
        Assert.assertTrue(!driver.findElements(By.cssSelector(".header-logo")).isEmpty(), "not found logo");
        searchPage.clickcompanies();
        Assert.assertTrue(!driver.findElements(By.cssSelector("[href = '/issoft']")).isEmpty(), "not found isSoft");
        searchPage.clicksalaries();
        Assert.assertTrue(!driver.findElements(By.cssSelector(".input.info-count")).isEmpty(), "not found salary");
        searchPage.clickjobs();
        Assert.assertTrue(!driver.findElements(By.cssSelector(".column-left")).isEmpty(), "not found jobs");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}