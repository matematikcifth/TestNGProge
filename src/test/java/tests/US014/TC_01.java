package tests.US014;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.security.Key;

public class TC_01 extends ExtentReport {

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Allover_Commerce", "Allover_Commerce Test Edilebilmeli.");

        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("sayfaya gidildi...");

        Allover_Commerce_Page allover = new Allover_Commerce_Page();

        allover.signInClick.click();
        ReusableMethods.bekle(1);
        extentTest.info("signIn butonuna basildi.");

        allover.vendorEmail.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ReusableMethods.bekle(1);
        allover.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"),
                Keys.TAB, Keys.ENTER);
        extentTest.info("email ve password bilgileri girildi...");

        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(allover.myAccount);
        ReusableMethods.bekle(1);

        allover.myAccount.click();
        ReusableMethods.bekle(1);
        extentTest.info("sayfa sonunda bulunan myAccount butonuna tiklanildi.");
        allover.storeManager.click();
        ReusableMethods.bekle(1);
        extentTest.info("acilan sayfa da storeManager butonuna tiklanild.");
        allover.product.click();
        ReusableMethods.bekle(1);
        allover.addNew.click();
        ReusableMethods.bekle(1);
        extentTest.info("acilan sayfa da product butonuna tiklanild.");

        allover.productType.click();
        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaResmi();
        allover.productType.click();
        ReusableMethods.bekle(1);
        Assert.assertTrue(allover.productType.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("product type secilme islemi yapildi.");
        allover.imgClick.click();
        ReusableMethods.bekle(2);

        //"C:\Users\Omer\OneDrive\Masaüstü\pexels-photo-7961670.jpeg"
        //  "C:\Users\Omer \OneDrive\Masaüstü\free-photo-of-kent-safak-gun-batimi-su.jpeg"

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\free-photo-of-kent-safak-gun-batimi-su.jpeg";
        String dosyaYolu = farkliKisim + ortakKisim;


        ReusableMethods.click(allover.selectFileNew);
        ReusableMethods.uploadFile(dosyaYolu);
        ReusableMethods.bekle(10);
        ReusableMethods.tumSayfaResmi();
        allover.selectFotoButton.click();

        extentTest.pass("bilgisayardan fotograf yukleme islemi yapildi...");

        ReusableMethods.bekle(1);

        ReusableMethods.click(allover.prductTittle);
        ReusableMethods.bekle(1);
        allover.prductTittle.sendKeys("green page");
        extentTest.info("produt tittle ismi yazildi...");

        ReusableMethods.bekle(1);

        Driver.getDriver().switchTo().frame(allover.iframe);
        ReusableMethods.click(allover.shortDescription);
        allover.shortDescription.sendKeys("green page shortDescription");
        ReusableMethods.bekle(1);
        Driver.getDriver().switchTo().parentFrame();
        ReusableMethods.bekle(1);
        extentTest.info("shortDescription kutucugan yazi yazildi...");

        Driver.getDriver().switchTo().frame(allover.iframe1);
        ReusableMethods.click(allover.description);
        allover.description.sendKeys("green page description");
        ReusableMethods.bekle(1);
        Driver.getDriver().switchTo().parentFrame();
        ReusableMethods.bekle(1);
  extentTest.info("Description kutucuguna yazi yaildi");

        allover.categories.click();
        ReusableMethods.bekle(1);
        extentTest.info("categories kismi tiklanildi...");
        allover.addNewCategory.click();
        ReusableMethods.bekle(1);
        allover.categoryName.sendKeys("greenn category new");
        ReusableMethods.bekle(1);

        Select ddm = new Select(allover.parentddm);
        ddm.selectByVisibleText("         Sang");
        ReusableMethods.bekle(1);
        ReusableMethods.scroll(allover.addCategory);
        ReusableMethods.bekle(1);
        allover.addCategory.click();
        ReusableMethods.bekle(2);
        extentTest.info("yeni kategory ekleme islemleri yapildi...");

        ReusableMethods.click(allover.addNewProduct);
        ReusableMethods.bekle(1);
        allover.productBrands.click();
        ReusableMethods.bekle(1);
        //  allover.addNewProduct.click();
        ReusableMethods.bekle(2);
        ReusableMethods.click(allover.addProduct);
        ReusableMethods.bekle(1);
        ReusableMethods.click(allover.productName);
        ReusableMethods.bekle(1);
        allover.productName.sendKeys("green producht name new");
        ReusableMethods.bekle(1);
        Select ddm1 = new Select(allover.productddm);
        ddm1.selectByVisibleText("   LeonPrcd");
        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaResmi();
        allover.addProduct.click();
        ReusableMethods.bekle(2);
        ReusableMethods.alertAccept();
        ReusableMethods.bekle(1);
        extentTest.info("yeni product ekleme islemleri yapildi...");

        Driver.closeDriver();


    }

}
