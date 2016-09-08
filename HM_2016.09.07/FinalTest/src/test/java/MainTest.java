import core.TestBase;
import helpers.HelperRandomClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Lenovo on 8/29/2016.
 */
public class MainTest extends TestBase{

    @Test
    public void ContactUsTest(){
        String asserttext = "Your message has been successfully sent to our team.";

        HeaderButtons.clickContactUs(driver);
        FillOutTheLoginForm.filloutAlldatas(driver);
        assertEquals(driver.findElement(By.cssSelector("#center_column>p")).getText(),asserttext);
    }

    @Test
    public void ContactUsTestErrorMessage(){
        String asserterrortext = "The message cannot be blank.";

        HeaderButtons.clickContactUs(driver);
        FillOutTheLoginForm.filloutWithoutMessageField(driver);
        assertEquals(driver.findElement(By.cssSelector("#center_column>div>ol>li")).getText(),asserterrortext);
    }

    @Test
    public void RegisterTest(){
        String assertregistertext = "My account - My Store";

        HeaderButtons.clickSignIn(driver);
        CreateAccount.EnterEmail(driver);
        CreateAccount.FillOutRegistryForm(driver);
        assertEquals(driver.getTitle(), assertregistertext);
    }

    @Test
    public void SearchTest(){
        String assertpricetext = "$27.00";

        SearchClothes.SearchBySearchLine(driver);
        assertEquals(driver.findElement(By.cssSelector("#center_column div.right-block > div.content_price > span")).getText(),assertpricetext);

    }

    @Test
    public void DeleteItemFromShoppingCart(){
        String text1product = "Cart 1 Product";
        String textempty = "Cart (empty)";

        SearchClothes.SearchBySearchLine(driver);
        BuyClothes.AddToCart(driver);
        BuyClothes.ContinyeShopping(driver);
        assertEquals(driver.findElement(By.cssSelector(".shopping_cart>a")).getText(), text1product);

        BuyClothes.DeleteFromCart(driver);
        BuyClothes.ClickCart(driver);
        assertEquals(driver.findElement(By.cssSelector(".shopping_cart>a")).getText(), textempty);
    }

    @Test
    public void CatalogTest(){
        String assertcatalogtext = "Faded Short Sleeve T-shirts\n" +
                "$16.51\n" +
                "In stock";

        SearchClothes.SearchTShirtByMenu(driver);
        assertEquals (driver.findElement(By.cssSelector(".product-container")).getText(), assertcatalogtext);
    }

    @Test
    public void CheckoutTest(){
        String assertstep1 = "Blouse";
        String assertstep3 = "YOUR DELIVERY ADDRESS";
        String assertstep5 = "Blouse";
        String assertconfirm = "Your order on My Store is complete.";

        SearchClothes.SearchBySearchLine(driver);
        BuyClothes.AddToCart(driver);
        BuyClothes.ContinyeShopping(driver);
        BuyClothes.ClickCart(driver);
        assertEquals(driver.findElement(By.cssSelector(".cart_description>p>a")).getText(), assertstep1);
        BuyClothes.ClickContinueOrder(driver);
        CreateAccount.EnterEmail(driver);
        CreateAccount.FillOutRegistryForm(driver);
        assertEquals(driver.findElement(By.cssSelector(".address_title")).getText(), assertstep3);
        assert(driver.findElement(By.cssSelector("#address_delivery > li.address_address1.address_address2")).isDisplayed());
        BuyClothes.ClickNotUseAddressAsTheBilling(driver);
        BuyClothes.ClickContinueOrder(driver);
        BuyClothes.AgreeService(driver);
        BuyClothes.ClickContinueOrder(driver);
        assertEquals(driver.findElement(By.cssSelector(".cart_description>p>a")).getText(), assertstep5);
        BuyClothes.PayByBankWire(driver);
        BuyClothes.ConfirmOrder(driver);
        assertEquals(driver.findElement(By.cssSelector(".cheque-indent>.dark")).getText(), assertconfirm);

    }

    @Test
    public  void AddToWishList(){
        HeaderButtons.clickSignIn(driver);
        CreateAccount.EnterEmail(driver);
        CreateAccount.FillOutRegistryForm(driver);
        SearchClothes.SearchBySearchLine(driver);
        BuyClothes.AddToWishList(driver);
        BuyClothes.LookThroughtMyWish(driver);
        assertEquals(driver.findElement(By.id("s_title")).getText(), "Blouse");

    }

    @Test
    public void PriceLine(){
        SearchClothes.SearchTShirtByMenu(driver);
        SearchClothes.PriceLine(driver);
        assertEquals(driver.findElement(By.cssSelector("#layered_price_range")).getText(), "$16.00 - $17.00");

    }

    @Test
    public void SelectDress(){
        SearchClothes.SelectDressUseManyItems(driver);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement menu = driver.findElement(By.cssSelector(".left-block"));
        Actions action = new Actions(driver);
        action.moveToElement(menu).build().perform();
        assertEquals(driver.findElement(By.cssSelector("#center_column .content_price > span")).getText(), "$30.50");
    }

    @Test
    public void CompareDresses(){
        SearchClothes.SelectDress(driver);
        SearchClothes.CompareDresses(driver);
        assertEquals(driver.getTitle(), "Products Comparison - My Store");
        assertEquals(driver.findElement(By.cssSelector(".product-block.product-3 .prices-container > span")).getText(), "$26.00");
        assertEquals(driver.findElement(By.cssSelector(".product-block.product-4 .prices-container > span")).getText(), "$50.99");
    }

    @Test
    public void SortDresses(){
        SearchClothes.SelectDress(driver);
        SearchClothes.SortByLowest(driver);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(driver.findElement(By.cssSelector(".left-block>div>a")).getAttribute("title"), "Printed Chiffon Dress");

    }



}
