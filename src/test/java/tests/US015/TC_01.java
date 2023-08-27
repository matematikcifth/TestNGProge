package tests.US015;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        extentTest.info("sayfaya gidildi.");

        Allover_Commerce_Page allover = new Allover_Commerce_Page();

        allover.signInClick.click();
        ReusableMethods.bekle(1);
        extentTest.info("signIn butonuna tiklanildi");

        allover.vendorEmail.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ReusableMethods.bekle(1);
        allover.vendorPassword.sendKeys(ConfigReader.getProperty("vendorPassword"),
                Keys.TAB, Keys.ENTER);
        extentTest.info("email ve password bilgileri girilip giris yapildi.");

        ReusableMethods.bekle(2);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(allover.myAccount);
        ReusableMethods.bekle(1);
        allover.myAccount.click();
        ReusableMethods.bekle(1);
        extentTest.info("sayfanin alt kisminda bulunan 'myAccount' butonuna tiklanildi.");

        allover.storeManager.click();
        ReusableMethods.bekle(1);
        extentTest.info("Hesap Sayfasinda Store Manger butonuna tiklanildi.");

        allover.product.click();
        ReusableMethods.bekle(1);
        extentTest.info("Acilan sayfada product butonuna tiklanildi.");

        allover.addNew.click();
        ReusableMethods.bekle(1);
        ReusableMethods.scroll(allover.scroollToPage);
        ReusableMethods.bekle(1);
        ReusableMethods.tumSayfaResmi();

        Assert.assertTrue(allover.inventory.isDisplayed());
        Assert.assertTrue(allover.shipping.isDisplayed());
        Assert.assertTrue(allover.attribute.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Sayfani asagisinda 'inventory' vs dogrulama islemi yapildi");

        allover.sku.sendKeys("sku new product", Keys.TAB, Keys.SPACE);
        Assert.assertNotEquals(allover.sku.getAttribute("value"), null);

        allover.stockQty.clear();
        allover.stockQty.sendKeys("2");
        ReusableMethods.bekle(1);
        Assert.assertNotEquals(allover.stockQty.getAttribute("value"), null);
        //girilen sendkeys kisminin yazildigini dogrulama islemi

        Select ddm = new Select(allover.backordersddm);
        ddm.selectByVisibleText("Allow");
        ReusableMethods.bekle(1);
        extentTest.pass("inventory islemleri yapildi.");

        allover.shippingClick.click();
        ReusableMethods.bekle(1);
        extentTest.info("shipping butonuna basildi.");

        allover.weightText.sendKeys("10", Keys.TAB);
        WebElement next = Driver.getDriver().switchTo().activeElement();
        next.sendKeys("15", Keys.TAB);
        ReusableMethods.bekle(1);
        WebElement next1 = Driver.getDriver().switchTo().activeElement();
        next1.sendKeys("20", Keys.TAB);
        ReusableMethods.bekle(1);
        WebElement next2 = Driver.getDriver().switchTo().activeElement();
        next2.sendKeys("20", Keys.TAB);
        ReusableMethods.bekle(1);
        allover.shippinClassClick.click();
        ReusableMethods.bekle(1);
        allover.shippinClassClick.click();

        Select ddm1 = new Select(allover.proccessingTimeClick);
        ddm1.selectByVisibleText("1-2 business days");
        ReusableMethods.bekle(1);
        extentTest.pass("shipping islemleri yapildi.");

        allover.attributesClick.click();
        ReusableMethods.bekle(1);
        extentTest.info("attributes butonuna basildi.");

        allover.attributeColorClick.click();
        ReusableMethods.bekle(1);
        //allover.colorText.click();

        ReusableMethods.click(allover.colorText);
        // Select ddm2 = new Select(allover.colorChoice);
        //ddm2.selectByVisibleText("mavi");
        ReusableMethods.bekle(1);
        ReusableMethods.click(allover.colorChoice1);
        ReusableMethods.bekle(1);
        allover.addNew2.click();
        ReusableMethods.bekle(1);
        ReusableMethods.alertprompt("oft123");
        ReusableMethods.bekle(2);
        ReusableMethods.alertAccept();
        ReusableMethods.bekle(2);
        ReusableMethods.click(allover.selectNone1);

        ReusableMethods.bekle(1);
        ReusableMethods.click(allover.clickSize);
        ReusableMethods.bekle(1);
        ReusableMethods.click(allover.colorSizeText);
        ReusableMethods.bekle(1);
        ReusableMethods.click(allover.colorChoice3);
        ReusableMethods.bekle(1);
        allover.addNew3.click();
        ReusableMethods.bekle(1);
        ReusableMethods.alertprompt("123-456-789");
        ReusableMethods.bekle(2);
        ReusableMethods.alertAccept();
        ReusableMethods.bekle(2);
        ReusableMethods.click(allover.selectNone2);
        ReusableMethods.bekle(2);
        extentTest.pass("attributes islemleri yapildi.");

        Driver.closeDriver();


    }
}
