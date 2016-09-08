package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Lenovo on 8/31/2016.
 */
public class SearchClothes {

    public static final By MAIN_MENU_WOMAN = Locators.get("MainMenuWoman");
    public static final By DROP_DOWN_MENU_TSHIRTS = Locators.get("DropDownMenuTshirts");
    public static final By SEARCH_QUERY_TOP = Locators.get("SearchQueryTop");
    public static final By PRICE_LINE = Locators.get("PriceLine");
    public static final By MAIN_MENU_DRESSES = Locators.get("MainMenuDresses");
    public static final By CHECK_SUMMER_DRESSES = Locators.get("CheckSummerDresses");
    public static final By CHECK_COLOR_YELLOW = Locators.get("CheckColorYellow");
    public static final By CHECK_SHORT_DRESS = Locators.get("CheckShortDress");
    public static final By ADD_TO_COMPARE = Locators.get("AddToCompare");
    public static final By SELECT_VISCOSE_DRESS = Locators.get("SelectViscoseDress");
    public static final By ADD_TO_COMPARE_VISCOSE_DRESS = Locators.get("AddToCompareViscoseDress");
    public static final By CHECK_VISCOSE = Locators.get("CheckViscose");
    public static final By COMPARE_BUTTON = Locators.get("CompareButton");
    public static final By SELECT_ITEM = Locators.get("SelectItem");
    public static final By SORT_BY = Locators.get("SortBy");


    public static void SearchBySearchLine(WebDriver driver) {

        String searchtext = "Blouse";

        WebElement textbox = driver.findElement(SEARCH_QUERY_TOP);
        textbox.sendKeys(searchtext);
        textbox.submit();

    }

    public static void SearchTShirtByMenu(WebDriver driver) {

        WebElement menu = driver.findElement(MAIN_MENU_WOMAN);

        Actions action = new Actions(driver);
        action.moveToElement(menu).build().perform();
        driver.findElement(DROP_DOWN_MENU_TSHIRTS).click();

    }

    public static void PriceLine(WebDriver driver){
        WebElement item = driver.findElement(PRICE_LINE);
        Actions action = new Actions(driver);
        action.moveToElement(item).dragAndDropBy(item, -500, 0).build().perform();
    }

    public static void SelectDress(WebDriver driver){
        driver.findElement(MAIN_MENU_DRESSES).click();
    }

    public static void SelectDressUseManyItems(WebDriver driver){
        driver.findElement(MAIN_MENU_DRESSES).click();
        driver.findElement(CHECK_SUMMER_DRESSES).click();
        driver.findElement(CHECK_COLOR_YELLOW).click();
        driver.findElement(CHECK_SHORT_DRESS).click();
    }

    public static void AddCompareDress1(WebDriver driver){
        WebElement item = driver.findElement(SELECT_ITEM);
        Actions action = new Actions(driver);
        action.moveToElement(item).build().perform();
        driver.findElement(ADD_TO_COMPARE).click();
    }

    public static void AddCompareDress2(WebDriver driver){
        WebElement item = driver.findElement(SELECT_VISCOSE_DRESS);
        Actions action = new Actions(driver);
        action.moveToElement(item).build().perform();
        driver.findElement(ADD_TO_COMPARE_VISCOSE_DRESS).click();
    }

    public static void CompareDresses(WebDriver driver){
        AddCompareDress1(driver);
        driver.findElement(CHECK_VISCOSE).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AddCompareDress2(driver);
        driver.findElement(COMPARE_BUTTON).click();

    }

    public static void SortByLowest(WebDriver driver){
        WebElement lowest = driver.findElement(SORT_BY);
        lowest.sendKeys("Price: Lowest first");
        lowest.sendKeys(Keys.ENTER);

    }



}
