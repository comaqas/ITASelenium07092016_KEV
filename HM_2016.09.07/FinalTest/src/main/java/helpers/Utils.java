package helpers;

import core.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Lenovo on 9/5/2016.
 */
public class Utils {

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name){
        return ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
