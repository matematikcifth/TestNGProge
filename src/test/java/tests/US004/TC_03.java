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

public class TC_03 extends ExtentReport {
    @Test
    public void test03() {
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

        //    enter your first name on "First name * " section

        //    enter your lastname on "Last name * " section
        page.shippingLastName.clear();
        extentTest.info("Soyisim kutusu temizlendi");

        //    enter your street addres on "Street address " section
        //    enter your town  on "Town/City" section
        //    enter your Zip Code on "Postcode/Zip*" section

        page.shippingFirstName.sendKeys("", Keys.TAB, "", Keys.TAB,
                Keys.TAB, Keys.TAB, "fgdshjsdk", Keys.TAB, Keys.TAB, "gfdkkj", Keys.TAB, Keys.TAB+ "1234");

        //    Select your country/region on "Country/Region *" selection
        WebElement countrySelect = page.shippingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Australia");
        extentTest.info("Ülke seçimi yapıldı");

        //    select your State on "State *" section
        WebElement stateSelect = page.shippingStateSelect;
        Select select1 = new Select(stateSelect);
        select1.selectByIndex(4);
        ReusableMethods.bekle(2);
        extentTest.info("Eyalet seçimi yapıldı");

        //    Click the "SAVE ADDRESS" button
        WebElement shippingAddress = page.billingSubmit;
        ReusableMethods.click(shippingAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet butonuna tıklandı");

        //    Check the "Mistake Report" after click the save address button
        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());
        extentTest.info("Adresi Kaydet butonuna tıkladıktan sonra gelen Hata Raporu test edildi");

        extentTest.pass("Kontrol Edildi");
        extentReports.flush();

    }
}



