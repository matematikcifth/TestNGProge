package tests.US008;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_01_WishlistPages extends ExtentReport {

    @Test
    public void WishlistPages () {
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");

        Allover_Commerce_Page allover = new Allover_Commerce_Page();


        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Sayfaya Gidildi");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,1000)");
        ReusableMethods.bekle(3);
        extentTest.info("Sayfada kaydirma asagi yapildi");


        //ReusableMethods.scroll("chess");


        //Actions actions = new Actions(Driver.getDriver());
        allover.chess.click();

        extentTest.info("Secilen urune tiklandi");

        js.executeScript("window.scrollTo(0,300)");
        ReusableMethods.bekle(5);
        extentTest.info("Sayfada scroll yapildi");


        allover.chess_kalp.click();

        ReusableMethods.scrollHome();
        ReusableMethods.bekle(2);
        extentTest.info("Wish simgesine tiklandi");

        allover.wishlistKalp.click();

        ReusableMethods.bekle(2);
        Assert.assertTrue(allover.inStock.isEnabled());

        extentTest.info("Urunun wischlist te oldugu kontrol edildi");




    }
}
