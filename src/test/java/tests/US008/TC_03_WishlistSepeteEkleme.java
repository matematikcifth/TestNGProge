package tests.US008;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.awt.geom.RectangularShape;

public class TC_03_WishlistSepeteEkleme extends ExtentReport {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Fatih","Allovercommerce Test Edebilmeli");

        Allover_Commerce_Page allover = new Allover_Commerce_Page();
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

        extentTest.info("Sayfaya Gidildi");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,1000)");
        ReusableMethods.bekle(3);

        extentTest.info("Sayfada kaydirma asagi yapildi");

        //Actions actions = new Actions(Driver.getDriver());
        allover.chess.click();
        //js.executeScript("window.scrollTo(0,1000)");
        ReusableMethods.bekle(3);

        extentTest.info("Secilen urune tiklandi");

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
        extentTest.info("quickView sekmesine tiklandi");


        ReusableMethods.bekle(2);
        //allover.addToChart.click();
        js.executeScript("arguments[0].click();",allover.quickView_kapat);

        ReusableMethods.bekle(3);

        WebElement addToCartButton = allover.addToChartf;
        ReusableMethods.click(addToCartButton);
        ReusableMethods.bekle(3);
        extentTest.info("addToCartButton a tiklandi");

        allover.cartfth.click();
        ReusableMethods.bekle(2);
        extentTest.info("cart butununa tiklandi");

        allover.view_cartfth.click();
        ReusableMethods.bekle(2);
        extentTest.info("sepete gidildi");

        JavascriptExecutor jss = (JavascriptExecutor) Driver.getDriver();
        jss.executeScript("window.scrollTo(0,300)");
        ReusableMethods.bekle(3);
        extentTest.info("Scroll yapildi");


        allover.proceedto_checkout.click();
        ReusableMethods.bekle(2);
        extentTest.info(".proceedto_checkout sekmesine tiklandi");

        // Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        allover.billigadres_firstname_kutucugu.click();
        ReusableMethods.bekle(1);
        allover.billigadres_firstname_kutucugu.sendKeys(ConfigReader.
                getProperty("firstname") , Keys.TAB,ConfigReader.getProperty("lastname"),Keys.TAB,
                ConfigReader.getProperty("company"),Keys.TAB,Keys.ENTER,ConfigReader.getProperty("country"),Keys.ENTER,Keys.TAB );


        allover.streetadres_kutusu.clear();


        allover.streetadres_kutusu.sendKeys(ConfigReader.getProperty("streetAdress"),Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("postcode"),Keys.TAB,ConfigReader.getProperty("cityfth"),Keys.TAB,Keys.ENTER,Keys.TAB,
                ConfigReader.getProperty("province"),Keys.ENTER,Keys.TAB);

        //allover.phone_kutusu.click();
        allover.phone_kutusu.sendKeys(ConfigReader.getProperty("phone"),Keys.TAB,ConfigReader.getProperty("otomatikEmail"));

   jss.executeScript("window.scrollTo(0,600)");

   ReusableMethods.bekle(2);

   extentTest.info("Billign Details dolduruldut ");

   allover.place_order_butonu.click();

   extentTest.info("Siparis verme butonu tiklandi");

   Assert.assertTrue(allover.thankyou_yazisi.isEnabled());
   ReusableMethods.bekle(3);

   extentTest.info("Siparis islemi tamamlandi");



    }
}
