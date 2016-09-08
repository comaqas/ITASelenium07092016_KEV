package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 * Created by Lenovo on 9/1/2016.
 */
public class BuyClothes {

    public static final By SELECT_ITEM = Locators.get("SelectItem");
    public static final By ADD_TO_CART_BUTTON = Locators.get("AddToCartButton");
    public static final By CONTINUE_SHOPPING = Locators.get("ContinueShoppingButton");
    public static final By CART_BUTTON = Locators.get("CartButton");
    public static final By REMOVE_ITEM = Locators.get("RemoveItem");
    public static final By PROCEED_TO_CHECKOUT = Locators.get("ProceedToCheckout");
    public static final By CLICK_NONE_BILLING_ADDRESS = Locators.get("ClickNoneBillingAddress");
    public static final By AGREE_SERVICE = Locators.get("AgreeService");
    public static final By PAY_BY_BANK_WIRE = Locators.get("PayByBankWire");
    public static final By CONFIRM_ORDER = Locators.get("ConfirmOrder");
    public static final By ADD_TO_WISH_LIST = Locators.get("AddToWishList");
    public static final By MY_WISHLISTS = Locators.get("MyWishlists");
    public static final By VIEW = Locators.get("View");


    public static void AddToCart(WebDriver driver){

        WebElement item = driver.findElement(SELECT_ITEM);

        Actions action = new Actions(driver);
        action.moveToElement(item).build().perform();
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public static void ContinyeShopping(WebDriver driver){
        driver.findElement(CONTINUE_SHOPPING).click();
    }

    public static void ClickCart(WebDriver driver){
        driver.findElement(CART_BUTTON).click();
    }

    public static void DeleteFromCart(WebDriver driver){

        WebElement item = driver.findElement(CART_BUTTON);

        Actions action = new Actions(driver);
        action.moveToElement(item).build().perform();
        driver.findElement(REMOVE_ITEM).click();
    }

    public static void ClickContinueOrder(WebDriver driver){
        driver.findElement(PROCEED_TO_CHECKOUT).click();
    }

    public static void ClickNotUseAddressAsTheBilling(WebDriver driver){
        driver.findElement(CLICK_NONE_BILLING_ADDRESS).click();
    }

    public static void AgreeService(WebDriver driver){
        driver.findElement(AGREE_SERVICE).click();
    }

    public static void PayByBankWire(WebDriver driver){
        driver.findElement(PAY_BY_BANK_WIRE).click();
    }

    public static void ConfirmOrder(WebDriver driver){
        driver.findElement(CONFIRM_ORDER).click();
    }

    public static void AddToWishList(WebDriver driver){
        WebElement item = driver.findElement(SELECT_ITEM);

        Actions action = new Actions(driver);
        action.moveToElement(item).build().perform();
        driver.findElement(ADD_TO_WISH_LIST).click();
    }

    public static void LookThroughtMyWish(WebDriver driver){
        driver.findElement(MY_WISHLISTS).click();
        driver.findElement(VIEW).click();
    }


}
