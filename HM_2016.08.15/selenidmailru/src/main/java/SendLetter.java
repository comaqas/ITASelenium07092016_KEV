import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Lenovo on 8/23/2016.
 */
public class SendLetter {
    public static void send(String recipient){
        $(Locators.get("ButtonWrite")).click();
        $(Locators.get("Recipient")).setValue(recipient);
        $(Locators.get("Subject")).setValue(HelperRandomClass.getRandomString());
        $(Locators.get("SmailButton")).click();
        $(Locators.get("SmailSend")).click();
        $(Locators.get("SendButton")).click();

        /*
            switchTo().innerFrame("compose_2451_composeEditor_ifr");
            $(By.id("tinymce")).setValue("Hello");
            switchTo().defaultContent();
    */

    }

}
