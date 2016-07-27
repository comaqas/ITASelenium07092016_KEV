import core.TestBase;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by Lenovo on 7/27/2016.
 */
public class DevbyTest extends TestBase {

    @Test
    public void ProjectElementTest(){
        MainPage.clickLenta(driver);
        Lenta.assertLenta(driver);
        MainPage.clickCompanies(driver);
        Companies.assertCompanies(driver);
        MainPage.clickSalaries(driver);
        Salaries.assertSalaries(driver);
        MainPage.clickJobs(driver);
        Jobs.assertJobs(driver);
    }

}
