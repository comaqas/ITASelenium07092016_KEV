package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lenovo on 7/27/2016.
 */
public class MainPage {

    private static final By LENTA = By.cssSelector("[href='https://dev.by/lenta']");
    private static final By COMPANIES = By.cssSelector("[href = 'https://companies.dev.by/']");
    private static final By SALARIES = By.cssSelector("[href = 'https://salaries.dev.by/']");
    private static final By JOBS = By.cssSelector("[href = 'https://jobs.dev.by/']");

    public static void clickLenta(WebDriver driver){
        WebElement lenta = driver.findElement(LENTA);
        lenta.click();
    }

    public static void clickCompanies(WebDriver driver){
        WebElement companies = driver.findElement(COMPANIES);
        companies.click();
    }

    public static void clickSalaries(WebDriver driver){
        WebElement salaries = driver.findElement(SALARIES);
        salaries.click();
    }

    public static void clickJobs(WebDriver driver){
        WebElement jobs = driver.findElement(JOBS);
        jobs.click();
    }
}
