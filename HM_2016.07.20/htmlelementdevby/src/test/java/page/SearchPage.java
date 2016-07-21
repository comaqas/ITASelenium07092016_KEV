package page;
import block.SearchBlock;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;


/**
 * Created by Lenovo on 20.07.2016.
 */
public class SearchPage{

    private SearchBlock searchBlock;

    public SearchPage(WebDriver driver){

        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void clicklenta(){
            searchBlock.clickButtonlenta();
    }
    public void clickcompanies(){
        searchBlock.clickButtoncompanies();
    }
    public void clicksalaries(){
        searchBlock.clickButtonsalaries();
    }
    public void clickjobs(){
        searchBlock.clickButtonjobs();
    }



    public Rectangle getRect() {

        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}