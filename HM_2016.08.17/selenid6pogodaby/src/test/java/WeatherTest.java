import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Lenovo on 8/22/2016.
 */
public class WeatherTest {

    @Test
    public void tableDimension(){
        open("http://6.pogoda.by/");
        $$(By.xpath(".//*[@id='forecast']/tbody/tr[1]/td")).shouldHave(size(6));
        $$(By.cssSelector("#forecast tr")).shouldHave(size(30));
    }

    @Test
    public void verifyText(){
        open("http://6.pogoda.by/");
        $(By.id("forecast")).shouldHave(Condition.text("Дата"));
        $$(By.id("forecast")).get(0).shouldHave(Condition.text("Дата"));
    }
}
