package tests.US006;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import javax.swing.*;

public class US_01 extends ExtentReport {

        /*
    Kullanıcı search box tan istediği bir ürünü arayabilmeli
- Aradığı ürünü sepete ekleyebilmeli (ADD TO CART)
- Sepete (Cart) eklediği ürünleri görebilmeli
- Sepete eklediği ürünlerin miktarını artırabilmeli ve azaltabilmeli
- Ürünleri satınalabilmek için fartura adresini görebilmeli
- Ödeme seçeneklerini görebilmeli ve seçebilmeli
- Alışverişini tamamlayabilmeli
     */

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Yavuz", "Allover_Commerce Test Edilebilmeli.");
        //1-Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        extentTest.info("Ana sayfaya gidildi.");

        //2-Click SIGN IN
        alloverCommercePage.signInClick.click();
            ReusableMethods.bekle(1);
        extentTest.info("SIGN IN butonuna tıklandı.");

        //3-Enter username or email address
        alloverCommercePage.userNameBox.sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);
        extentTest.pass("Kullanıcı adı veya e-posta adresi girildi.");

        //4-Enter password
        alloverCommercePage.userPassword.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
            ReusableMethods.bekle(3);
            extentTest.info("Şifre girildi.");

        //5-write "kazak" in the search box and enter
            //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.elementToBeClickable(alloverCommercePage.searchBox));
        alloverCommercePage.searchBox.sendKeys("kazak" + Keys.ENTER);
            ReusableMethods.bekle(5);
        extentTest.info("Arama kutusuna kazak yazıldı ve Enter tuşuna basıldı.");

        //6-Click the first product
        alloverCommercePage.firstProduct.click();
        extentTest.info("İlk ürüne tıklandı.");

        //7-Click on"Add to Chart" button
        alloverCommercePage.addToCartButton.click();
        extentTest.info("Sepete Ekle butonuna tıklandı.");

        //8-Click to the Cart button
        alloverCommercePage.clickToCartButton.click();
        extentTest.info("Sepete gidildi.");

        //9-Click on"View Chart" button
        alloverCommercePage.viewCartButton.click();
        extentTest.pass("Sepeti Görüntüle butonuna tıklandı.");

        //10-click on "+" button
        alloverCommercePage.plusButton.click();
        extentTest.info("+ butonuna tıklandı.");

        //11-Click on"update chart"
        alloverCommercePage.updateCartButton.click();
            ReusableMethods.bekle(5);
        extentTest.info("Sepeti Güncelle butonuna tıklandı.");

        //12-Click on "-" button
        alloverCommercePage.minusButton.click();
            ReusableMethods.bekle(5);
        extentTest.info("- butonuna tıklandı.");

       //13-Click on "update chart"
        alloverCommercePage.updateCartButton.click();
            ReusableMethods.bekle(5);
        extentTest.info("Sepeti Güncelle butonuna tıklandı.");

        //14-Click "Proceed To Checkout"" button for purchase
        ReusableMethods.click(alloverCommercePage.proceedToCheckout);
        ReusableMethods.bekle(5);
        extentTest.info("Satın almaya devam etmek için Ödeme Yap butonuna tıklandı.");

        //15-Verifiy you are in "Billing Details" Page
        Assert.assertTrue(alloverCommercePage.billingDetails.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Fatura detaylari goruldu");

        //16-Is payment method visible
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Ödeme yönteminin görünür olduğu kontrol edildi.");

        //17-Click on "pay with EFT"
        ReusableMethods.click(alloverCommercePage.eftButton);
            ReusableMethods.bekle(1);
        extentTest.info("EFT Ödeme seçeneğine tıklandı.");

        //18-Click on "Place order" button
        ReusableMethods.click(alloverCommercePage.placeOrderButton); //click yapar
            ReusableMethods.bekle(1);
        extentTest.info("Siparişi Tamamla butonuna tıklandı.");

        //19-Verify the message of "Thank you. Your order has been received.
        Assert.assertTrue(alloverCommercePage.thankYou.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Teşekkür ederiz. Siparişiniz alındı. mesajı doğrulandı.");

        Driver.quitDriver();

    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Yavuz", "Allover_Commerce Test Edilebilmeli.");
        //1-Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        extentTest.info("Ana sayfaya gidildi.");

        //2-Click SIGN IN
        alloverCommercePage.signInClick.click();
        ReusableMethods.bekle(1);
        extentTest.info("SIGN IN butonuna tıklandı.");

        //3-Enter username or email address
        alloverCommercePage.userNameBox.sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);
        extentTest.pass("Kullanıcı adı veya e-posta adresi girildi.");

        //4-Enter password
        alloverCommercePage.userPassword.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.info("Şifre girildi.");

        //5-write "kazak" in the search box and enter
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(alloverCommercePage.searchBox));
        alloverCommercePage.searchBox.sendKeys("kazak" + Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.info("Arama kutusuna kazak yazıldı ve Enter tuşuna basıldı.");

        //6-Click the first product
        alloverCommercePage.firstProduct.click();
        extentTest.info("İlk ürüne tıklandı.");

        //7-Click on"Add to Chart" button
        alloverCommercePage.addToCartButton.click();
        extentTest.info("Sepete Ekle butonuna tıklandı.");

        //8-Click to the Cart button
        alloverCommercePage.clickToCartButton.click();
        extentTest.info("Sepete gidildi.");

        //9-Click on"View Chart" button
        alloverCommercePage.viewCartButton.click();
        extentTest.pass("Sepeti Görüntüle butonuna tıklandı.");

        //10-click on "+" button
        alloverCommercePage.plusButton.click();
        extentTest.info("+ butonuna tıklandı.");

        //11-Click on"update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("Sepeti Güncelle butonuna tıklandı.");

        //12-Click on "-" button
        alloverCommercePage.minusButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("- butonuna tıklandı.");

        //13-Click on "update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.info("Sepeti Güncelle butonuna tıklandı.");

        //14-Click "Proceed To Checkout"" button for purchase
        ReusableMethods.click(alloverCommercePage.proceedToCheckout);
        ReusableMethods.bekle(5);
        extentTest.info("Satın almaya devam etmek için Ödeme Yap butonuna tıklandı.");

        //15-Verifiy you are in "Billing Details" Page
        Assert.assertTrue(alloverCommercePage.billingDetails.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Fatura detaylari goruldu");

        //16-Is payment method visible
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Ödeme yönteminin görünür olduğu kontrol edildi.");

        //17-Click on "pay at the door"
        ReusableMethods.click(alloverCommercePage.payAtTheDoorButton);
        ReusableMethods.bekle(1);
        extentTest.info("kapida Ödeme seçeneğine tıklandı.");

        //18-Click on "Place order" button
        ReusableMethods.click(alloverCommercePage.placeOrderButton); //click yapar
        ReusableMethods.bekle(1);
        extentTest.info("Siparişi Tamamla butonuna tıklandı.");

        //19-Verify the message of "Thank you. Your order has been received.
        Assert.assertTrue(alloverCommercePage.thankYou.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Teşekkür ederiz. Siparişiniz alındı. mesajı doğrulandı.");

        Driver.quitDriver();

    }
}
