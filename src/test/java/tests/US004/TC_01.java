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


public class TC_01 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Esen" , "Allovercommerce Test Edebilmeli");

        //go to the website
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //Sign in your account
        Allover_Commerce_Page page = new Allover_Commerce_Page();
        page.singIn.click();
        page.userName.sendKeys(ConfigReader.getProperty("email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.TAB, Keys.ENTER);
        extentTest.info("Giriş yapıldı.");


        //Go to "myAccount"
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.myAccountButton);
        extentTest.info("Hesabım bölümüne tıklandı");

        //Make sure that user see the "Addresses" and Click the "Addresses
        Assert.assertTrue(page.addressesButton.isDisplayed());
        page.addressesButton.click();
        extentTest.info("Adres bölümünün görüldüğü kontrol edildi ve tıklandı");

        //Click the shipping address "Edit" button under the shipping address
        WebElement yazi2 =page.editShippingAddress;
        ReusableMethods.scroll(yazi2);
        ReusableMethods.bekle(2);
        page.editShippingAddress.click();
        extentTest.info("Teslimat Adresi bölümünün altındaki edit butonuna tıklandı");

        //enter yor first name on "First name * " section
        //enter your lastname on "Last name * " section
        //enter your street addres on "Street address " section
        //enter your town  on "Town/City" section
        //enter your Zip Code on "Postcode/Zip*" section

        page.shippingFirstName.sendKeys("lale", Keys.TAB, "lalezar", Keys.TAB,
                Keys.TAB, Keys.TAB, "fgdshjsdk", Keys.TAB, Keys.TAB, "gfdkkj", Keys.TAB, Keys.TAB+ "1234");
        extentTest.info("Adres bilgileri girildi");

        //Select your country/region on "Country/Region *" selection
        WebElement countrySelect = page.shippingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Australia");
        extentTest.info("Ülke bilgileri seçimi yapıldı");

        //select your State on "State *" section
        WebElement stateSelect = page.shippingStateSelect;
        Select select1 = new Select(stateSelect);
        select1.selectByIndex(4);
        ReusableMethods.bekle(2);
        extentTest.info("Eyalet seçildi");

        //Click the "SAVE ADDRESS" button
        WebElement shippingAddress = page.billingSubmit;
        ReusableMethods.click(shippingAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet butonuna tıklandı");


        //Make sure that user can see the "Address changed successfully." after click the save address button
        Assert.assertTrue(page.shippingAlert.isDisplayed());
        extentTest.info("Adresi Kaydet butonuna tıkladıktan sonra 'Address changed successfully' yazısı test edildi");

        extentTest.pass("Kontrol Edildi");
        extentReports.flush();

    }
}


