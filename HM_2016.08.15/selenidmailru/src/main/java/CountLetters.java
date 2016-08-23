import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Lenovo on 8/23/2016.
 */
public class CountLetters {
    public static void count(){
        $(By.className("b-datalist__item__panel")).click();
        System.out.println($$(Locators.get("Countdatalist")).size());

        int letters =0;
        while (true){
            int tempLetters = $$(Locators.get("Countdatalist")).size();
            System.out.println("tempLetters "+ tempLetters);
            letters = letters+tempLetters;
            if($(Locators.get("Next")).is(Condition.exist) &&
                    !$(Locators.get("Next")).is(Condition.cssClass("b-toolbar__btn_disabled"))){
                $(Locators.get("Right")).click();
                System.out.println("all letters "+letters);
            }else {
                break;
            }
        }
        System.out.println("all letters "+letters);
    }
}
