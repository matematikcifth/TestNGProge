package tests.US004;

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

public class TC_02 extends ExtentReport {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Esen" , "Allovercommerce Test Edebilmeli");

        //    go to the website
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //    Sign in your account
        Allover_Commerce_Page page = new Allover_Commerce_Page();
        page.singIn.click();
        page.userName.sendKeys(ConfigReader.getProperty("email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.TAB, Keys.ENTER);
        extentTest.info("Giriş yapıldı.");

        //    Go to "myAccount"
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.myAccountButton);
        extentTest.info("Hesabım bölümüne tıklandı");

        //    Make sure that user see the "Addresses" and Click the "Addresses
        Assert.assertTrue(page.addressesButton.isDisplayed());
        page.addressesButton.click();
        extentTest.info("Adres bölümünün görüldüğü kontrol edildi ve tıklandı");

        //    Click the shipping address "Edit" button under the shipping address
        WebElement yazi2 =page.editShippingAddress;
        ReusableMethods.scroll(yazi2);
        ReusableMethods.bekle(2);
        page.editShippingAddress.click();
        extentTest.info("Teslimat Adresi bölümünün altındaki edit butonuna tıklandı");

        //    clear your first name on "First name * " section
        page.shippingFirstName.clear();
        extentTest.info("İsim kutusu temizlendi");

        //    clear your lastname on "Last name * " section
        page.shippingLastName.clear();
        extentTest.info("Soyisim kutusu temizlendi");

        //    clear your street addres on "Street address " section
        page.shippingStreetName.clear();
        extentTest.info("Street Address kutusu temizlendi");

        //    clear your town  on "Town/City" section
        page.shippingTownName.clear();
        extentTest.info("Town/City  kutusu temizlendi");

        //    clear your Zip Code on "Postcode/Zip*" section
        page.shippingZipCode.clear();
        extentTest.info("Postecode kutusu temizlendi");

        //    Click the "SAVE ADDRESS" button
        WebElement shippingAddress = page.billingSubmit;
        ReusableMethods.click(shippingAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet butonuna tıklandı");

        //    Make sure that user can see the "Mistake Reports" after click the save address button
        Assert.assertTrue(page.shippingFirstNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingSuburbAllert.isDisplayed());
        Assert.assertTrue(page.shippingStreetAdressAllert.isDisplayed());
        Assert.assertTrue(page.shippingPostcodeAllert.isDisplayed());
        extentTest.info("Hata Raporları test edildi");

        extentTest.pass("Kontrol Edildi");
        extentReports.flush();
    }
}
