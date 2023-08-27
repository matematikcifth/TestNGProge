package tests.US008;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_02_WishlistQuickView extends ExtentReport {

    @Test
    public void test01() {
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

        //js.executeScript("window.scrollTo(0,1000)");
        ReusableMethods.bekle(1);
       // extentTest.info("Sayfada scroll yapildi");

        allover.chess_kalp.click();
        extentTest.info("Wish simgesine tiklandi");


        ReusableMethods.scrollHome();
        ReusableMethods.bekle(2);

        allover.wishlistKalp.click();
        extentTest.info("Wish liste gidildi");


        ReusableMethods.bekle(2);
        Assert.assertTrue(allover.inStock.isEnabled());
        extentTest.info("Urunun wishlistte oldugu  kontrol edildi");



        ReusableMethods.bekle(2);
        allover.quickView.click();

        ReusableMethods.bekle(2);

        extentTest.info("quickView sekmesine tiklandi");



        //allover.addToChart.click();
        js.executeScript("arguments[0].click();",allover.quickView_kapat);

        ReusableMethods.bekle(3);

        extentTest.info("quickView sekmesi kapatildi");



        WebElement addToCartButton = allover.addToChartf;
        ReusableMethods.click(addToCartButton);

        extentTest.info("addToCartButton a tiklandi");

        allover.cartfth.click();
        ReusableMethods.bekle(2);

        extentTest.info("cart butununa tiklandi");

        allover.view_cartfth.click();
        ReusableMethods.bekle(2);

        extentTest.info("sepete gidildi");

    }
}
