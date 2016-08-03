import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lenovo on 8/1/2016.
 */
public class LoginPage {

    WebDriver driver;

    By userName = By.id("mailbox__login");
    By password = By.id("mailbox__password");
    By autorization = By.id("mailbox__auth__button");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Set user name
    public void setUserName(String strUserName){

        driver.findElement(userName).sendKeys(strUserName);
    }
    //Set password
    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);
    }
    //Click login button
    public void clickLogin(){
        driver.findElement(autorization).click();
    }

    public void login(String strUserName, String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
    }

}
