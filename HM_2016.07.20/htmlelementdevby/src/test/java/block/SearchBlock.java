package block;
import org.openqa.selenium.*;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.awt.*;

/**
 * Created by Lenovo on 20.07.2016.
 */
@Name("Search block")
@Block(@FindBy(css = ".menu"))

public class SearchBlock  extends HtmlElement {

    @Name("Button lenta")
    @FindBy( css= "[href='https://dev.by/lenta']")
    private Button searchButtonLenta;

    @Name("Button companies")
    @FindBy(css = "[href = 'https://companies.dev.by/']")
    private Button searchButtonCompanies;

    @Name("Button salaries")
    @FindBy(css = "[href = 'https://salaries.dev.by/']")
    private Button searchButtonSalaries;

    @Name("Button jobs")
    @FindBy(css = "[href = 'https://jobs.dev.by/']")
    private Button searchButtonJobs;


    public void clickButtonlenta() {
        searchButtonLenta.click();
    }
    public void clickButtoncompanies() {
        searchButtonCompanies.click();
    }
    public void clickButtonsalaries() {
        searchButtonSalaries.click();
    }
    public void clickButtonjobs() {
        searchButtonJobs.click();
    }

    public Rectangle getRect() {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
