package tests.US011;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_01 extends ExtentReport {
    /*
           Vendor olarak Sign in yapılabilmeli
           1-Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli
           2-Dashboard altında ise; Store manager, orders, downloads, addresses ,
           account details, wishlist, Support tickets, followings ve log out olmali
           3-Dashboard altındaki bu menülere girilebilmeli.

           */
    @Test
    public void test01() {

        extentTest = extentReports.createTest("Fatma", "Allover_Commerce Test Edilebilmeli");

        // Adrese git.

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();

        extentTest.info("AlloverCommerce sayfasina gidildi");



       // sign in butonuna tikla

        alloverCommercePage.signInClick1fatma.click();

        ReusableMethods.bekle(3);

        extentTest.info("Sign in butonuna tiklandi");

        // Email adresi ve password gir

        alloverCommercePage.vendorEmail1fatma.sendKeys("tomerfaruk045@gmail.com");

        alloverCommercePage.vendorPassword1fatma.sendKeys("Oft.7106");

        ReusableMethods.bekle(3);

        extentTest.info("Sifre ve Email girildi");

        //sign in butonuna tikla.

        alloverCommercePage.signInClick2fatma.click();

        ReusableMethods.bekle(3);

        extentTest.info("Sign in butonuna tiklandi");

        // Vendor olarak sisteme girilebildigi test et(sing out buttonunun görünür olup olmadigi)

        Assert.assertTrue(alloverCommercePage.signOutButtonFatma.isDisplayed());

        extentTest.pass("Vendor olarak sisteme girilebildigi test edildi");

        //sayfa MY ACCOUNT yazisina kadar kaydir.

        ReusableMethods.scroll(alloverCommercePage.myAccount1fatma);

        // MY ACCOUNT YAZISININ GÖRÜNTÜLENDIGINI TEST ET

        Assert.assertTrue(alloverCommercePage.myAccount1fatma.isDisplayed());

        extentTest.pass("MY ACCOUNT yazisinin görüntülendigi test edildi");

        // En alttaki my account butonuna tikla.

        ReusableMethods.click(alloverCommercePage.myAccountEnAltFatma);

        extentTest.info("My Account yazisina tiklandi");


        //istenilen web elementlerin alt alta oldugunu görmek icin sayfayi önce
        // logout butonuna sonra dashboard yazisina kaydirarak sayfayi ortala.

        ReusableMethods.scroll(alloverCommercePage.logout1fatma);

        ReusableMethods.scroll(alloverCommercePage.dashboardFatma);

        ReusableMethods.bekle(3);

        // istenilen Web elementlerin görünür oldugu test et

        Assert.assertTrue(alloverCommercePage.storeManager1fatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.ordersFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.downloadsFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.addressesFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.accountDetailsFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.wishlistFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.supportTicketsFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.followingsFatma.isDisplayed());

        Assert.assertTrue(alloverCommercePage.logoutFatma.isDisplayed());

        extentTest.pass("Istenilen Web Elementlerin görüntülenebilir oldugu test edildi");


        // istenilen web elementlerin girilebilir oldugu test et

        Assert.assertTrue(alloverCommercePage.storeManager1fatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.ordersFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.downloadsFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.addressesFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.accountDetailsFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.wishlistFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.supportTicketsFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.followingsFatma.isEnabled());

        Assert.assertTrue(alloverCommercePage.logoutFatma.isEnabled());

        extentTest.pass("Istenilen Web Elementlerin girilebilir oldugu test edildi");
































    }
}
