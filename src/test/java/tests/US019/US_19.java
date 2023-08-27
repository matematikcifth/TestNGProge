package tests.US019;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US_19 extends ExtentReport {

    //Oluşturulan Coupon ile müşteri olarak alışveriş yapılabilmeli
    //- US_06 ile aynı
    //- Oluşturulan coupon ENTER YOUR CODE tıklanarak girilmeli

        @Test
    public void test_01() {
        extentTest = extentReports.createTest("Yavuz", "Allover_Commerce Test Edilebilmeli.");

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        extentTest.pass("Ana sayfaya gidildi.");

        //Click SIGN IN
        alloverCommercePage.signInButtonyvz.click();
        ReusableMethods.bekle(1);
        extentTest.pass("SIGN IN butonuna tıklandı.");

        //write email
        alloverCommercePage.userNameBox.sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);
        extentTest.pass("Kullanıcı adınızı veya e-posta adresinizi girdiniz.");

        //write password
        alloverCommercePage.userPassword.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.pass("Şifrenizi girdiniz.");

        //write "kazak" in the search box and enter
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(alloverCommercePage.searchBox));
        alloverCommercePage.searchBox.sendKeys("kazak" + Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.pass("Arama kutusuna kazak yazıldı ve Enter tuşuna basıldı.");

        //Click the first product
        alloverCommercePage.firstProduct.click();
        extentTest.pass("İlk ürüne tıklandı.");

        //Click on"Add to Chart" button
        alloverCommercePage.addToCartButton.click();
        extentTest.pass("Sepete Ekle butonuna tıklandı.");

        //Click to the Cart button
        alloverCommercePage.clickToCartButton.click();
        extentTest.pass("Sepete gidildi.");

        //Click on"View Chart" button
        alloverCommercePage.viewCartButton.click();
        extentTest.pass("Sepeti Görüntüle butonuna tıklandı.");

        //click on "+" button
        alloverCommercePage.plusButton.click();
        extentTest.pass("+ butonuna tıklandı.");

        //Click on"update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("Sepeti Güncelle butonuna tıklandı.");

        //Click on "-" button
        alloverCommercePage.minusButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("- butonuna tıklandı.");

        //Click on "update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("Sepeti Güncelle butonuna tıklandı.");

        //Click "Proceed To Checkout"" button for purchase
        ReusableMethods.click(alloverCommercePage.proceedToCheckout);
        ReusableMethods.bekle(5);
        extentTest.pass("Satın almaya devam etmek için Ödeme Yap butonuna tıklandı.");

        //Verifiy you are in "Billing Details" Page
        Assert.assertTrue(alloverCommercePage.billingDetails.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Fatura Detayları sayfasında olduğunuz doğrulandı.");

        //Is payment method visible
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Ödeme yönteminin görünür olduğu kontrol edildi.");

        //Click "ENTER YOUR CODE" section.
        alloverCommercePage.showCoupon.click();
        //ReusableMethods.bekle(5);
        extentTest.pass("KODUNUZU GİRİN bölümüne tıklandı.");

        //Apply coupon
        alloverCommercePage.couponDiscountBox.sendKeys("1234"+ Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.pass("Kodunuz 1234 olarak girildi ve Uygula butonuna tıklandı.");

        // click on "pay at the door"
        ReusableMethods.click(alloverCommercePage.payAtTheDoorButton);
        ReusableMethods.bekle(1);
        extentTest.pass("Kapida ode seçeneğine tıklandı.");

        //Click on "Place order" button
        ReusableMethods.click(alloverCommercePage.placeOrderButton); //click yapar
        ReusableMethods.bekle(1);
        extentTest.pass("Siparişi Tamamla butonuna tıklandı.");

        //Verify the message of "Thank you . Your order has been received.
        Assert.assertTrue(alloverCommercePage.thankYou.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Teşekkür ederiz. Siparişiniz alındı. mesajı doğrulandı.");

        Driver.quitDriver();
    }

    @Test
    public void test_02() {

        extentTest = extentReports.createTest("Yavuz", "Allover_Commerce Test Edilebilmeli.");

        //Go to homepage
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        extentTest.pass("Ana sayfaya gidildi.");

        //Click SIGN IN
        alloverCommercePage.signInButtonyvz.click();
        ReusableMethods.bekle(1);
        extentTest.pass("SIGN IN butonuna tıklandı.");

        //write email
        alloverCommercePage.userNameBox.sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);
        extentTest.pass("Kullanıcı adınızı veya e-posta adresinizi girdiniz.");

        //write password
        alloverCommercePage.userPassword.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(3);
        extentTest.pass("Şifrenizi girdiniz.");

        //write "kazak" in the search box and enter
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(alloverCommercePage.searchBox));
        alloverCommercePage.searchBox.sendKeys("kazak" + Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.pass("Arama kutusuna kazak yazıldı ve Enter tuşuna basıldı.");

        //Click the first product
        alloverCommercePage.firstProduct.click();
        extentTest.pass("İlk ürüne tıklandı.");

        //Click on"Add to Chart" button
        alloverCommercePage.addToCartButton.click();
        extentTest.pass("Sepete Ekle butonuna tıklandı.");

        //Click to the Cart button
        alloverCommercePage.clickToCartButton.click();
        extentTest.pass("Sepete gidildi.");

        //Click on"View Chart" button
        alloverCommercePage.viewCartButton.click();
        extentTest.pass("Sepeti Görüntüle butonuna tıklandı.");

        //click on "+" button
        alloverCommercePage.plusButton.click();
        extentTest.pass("+ butonuna tıklandı.");

        //Click on"update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("Sepeti Güncelle butonuna tıklandı.");

        //Click on "-" button
        alloverCommercePage.minusButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("- butonuna tıklandı.");

        //Click on "update chart"
        alloverCommercePage.updateCartButton.click();
        ReusableMethods.bekle(5);
        extentTest.pass("Sepeti Güncelle butonuna tıklandı.");

        //Click "Proceed To Checkout"" button for purchase
        ReusableMethods.click(alloverCommercePage.proceedToCheckout);
        ReusableMethods.bekle(5);
        extentTest.pass("Satın almaya devam etmek için Ödeme Yap butonuna tıklandı.");

        //Verifiy you are in "Billing Details" Page
        Assert.assertTrue(alloverCommercePage.billingDetails.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Fatura Detayları sayfasında olduğunuz doğrulandı.");

        //Is payment method visible
        Assert.assertTrue(alloverCommercePage.paymentMethods.isDisplayed());
        ReusableMethods.bekle(5);
        extentTest.pass("Ödeme yönteminin görünür olduğu kontrol edildi.");

        //Click "ENTER YOUR CODE" section.
        alloverCommercePage.showCoupon.click();
        //ReusableMethods.bekle(5);
        extentTest.pass("KODUNUZU GİRİN bölümüne tıklandı.");

        //Apply coupon
        alloverCommercePage.couponDiscountBox.sendKeys("1234"+ Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.pass("Kodunuz 1234 olarak girildi ve Uygula butonuna tıklandı.");

        // click on "pay with EFT"
        ReusableMethods.click(alloverCommercePage.eftButton);
        ReusableMethods.bekle(1);
        extentTest.pass("EFT ile ode seçeneğine tıklandı.");

        //Click on "Place order" button
        ReusableMethods.click(alloverCommercePage.placeOrderButton); //click yapar
        ReusableMethods.bekle(1);
        extentTest.pass("Siparişi Tamamla butonuna tıklandı.");

        //Verify the message of "Thank you . Your order has been received.
        Assert.assertTrue(alloverCommercePage.thankYou.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Teşekkür ederiz. Siparişiniz alındı. mesajı doğrulandı.");

        Driver.quitDriver();
    }
}
