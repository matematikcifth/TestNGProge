package tests.US012;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US_12 extends ExtentReport {

    @Test
    public void test01Pozitive() {
        extentTest=extentReports.createTest("M.Ali_12/TC01_PozitiveTest", "Allover_Commerce Test edilebilmeli.");
        //Vendor add Billing Address to web site (https://allovercommerce.com/)
        //(My Account - Adresses - Billing Address)
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("Sayfaya gidildi.");
        //Login as seller
        Allover_Commerce_Page alloverCommerce = new Allover_Commerce_Page();
        alloverCommerce.singin.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign in butonuna basıldı.");
        alloverCommerce.emailAyse.sendKeys
                (ConfigReader.getProperty("vendorEmail2"), Keys.TAB,
                        ConfigReader.getProperty("vendorPassword2"), Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor olarak log in yapıldı");
        //Go to the bottom of the page and click My Account
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(5);
        alloverCommerce.myAccount1.click();
        extentTest.info("Sayfanın en altına inilip 'myaccount' tıklandı.");
        //Click the "Addresses" link
        ReusableMethods.visibleWait(alloverCommerce.Addresses, 15);
        alloverCommerce.Addresses.click();
        ReusableMethods.bekle(3);
        extentTest.info("myAccountta 'Addresses' butonu tıklandı.");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Click "ADD" in the "Billing Address" section
        ReusableMethods.visibleWait(alloverCommerce.EditBillingAddress, 15);
        alloverCommerce.EditBillingAddress.click();
        extentTest.info("Fatura adresini değiştirmek için 'Edit Billing Address' butonu tıklandı.");
        //Verify that the e-mail is written automatically in the 'Email address' section on the 'Addresses' page
        Assert.assertTrue(alloverCommerce.verifyemailGetAutomatically.isDisplayed());
        extentTest.info("Fatura bilgileri açılınca e mail otomatik olarak yüklendi.");
        //Enter the 'First name'_Enter the 'Last name'
        alloverCommerce.addFirstName.clear();
        alloverCommerce.addLastName.clear();
        alloverCommerce.addFirstName.sendKeys
                (ConfigReader.getProperty("customarFirstNameForBillingAddress"), Keys.TAB,
                        ConfigReader.getProperty("customarLastNameForBillingAddress"), Keys.TAB, Keys.TAB);
        extentTest.info("Fatura adresine müşteri isim, soy  ismi girildi");
        //Enter the dropdown should also be able to select the States
        actions.sendKeys("(us)", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Drop down menüde 'United Sates (US)' seçildi.");
        //Enter the Street address
        alloverCommerce.addHouseNumberAndStreetName.sendKeys
                (ConfigReader.getProperty("Street"), Keys.TAB, Keys.TAB,
                        ConfigReader.getProperty("City"), Keys.TAB);
        actions.sendKeys("yor", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Sokak, şehir, state bilgisi girildi");
        //Enter the "ZIP/Code" //Enter the Phone Number
        alloverCommerce.addBillingPostCode.clear();
        alloverCommerce.addBillingPostCode.sendKeys
                (ConfigReader.getProperty("PostCode"), Keys.TAB,
                        ConfigReader.getProperty("PhoneNumber"), Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("ZipCode(Posta Kodu ve telefon numarası girildi. ");
        //Verify that the "SAVE ADDRESS" Button has been clicked
        extentTest.info("SAVE ADDRESS buttonu tıklandı.");
        //"The address has been successfully changed." Verify that "must see" appears
        Assert.assertTrue(alloverCommerce.addressChangedSuccessfully.getText().contains("Address changed successfully"));
        extentTest.info("'Adres başarılı bir şekilde değişti.' ifadesi görüldü. ve bu mesaj doğrulandı");
        //Close web browser
        Driver.closeDriver();
        extentTest.info("Chrome web browser kapatıldı.");
        extentReports.flush();
    }

    @Test
    public void test02Negative() {
        extentTest=extentReports.createTest("M.Ali_US_12/TC01_NegativeTest", "Allover_Commerce Test edilebilmeli.");
        //Login as seller
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Sayfaya gidildi.");
        //Go to the bottom of the page and click "My Account"
        Allover_Commerce_Page alloverCommerce = new Allover_Commerce_Page();
        alloverCommerce.singin.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign in butonuna basıldı.");
        alloverCommerce.emailAyse.sendKeys
                (ConfigReader.getProperty("vendorEmail2"), Keys.TAB,
                        ConfigReader.getProperty("vendorPassword2"), Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);

        //Go to the bottom of the page and click My Account
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(5);
        alloverCommerce.myAccount1.click();
        extentTest.info("Sayfanın en altına inilip 'myaccount' tıklandı.");
        //Click the "Addresses" link
        ReusableMethods.visibleWait(alloverCommerce.Addresses, 15);
        alloverCommerce.Addresses.click();
        extentTest.info("Address buttonu tıklandı. Billing ve shipping address alanına girildi");
        ReusableMethods.bekle(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Click "EDIT BILLING ADDRESS" in the "Billing Address" section
        ReusableMethods.visibleWait(alloverCommerce.EditBillingAddress, 15);
        alloverCommerce.EditBillingAddress.click();
        extentTest.info("Edit Billing Address buttonuna basıldı.");
        //Verify that the e-mail is written automatically in the 'Email address' section on the 'Addresses' page
        ReusableMethods.visibleWait(alloverCommerce.verifyemailGetAutomatically, 15);
        Assert.assertTrue(alloverCommerce.verifyemailGetAutomatically.isDisplayed());
        extentTest.info("emailin otomatik olarak sayfaya yüklendiği doğrulandı");
        //Don't enter the 'First name and 'Last name'
        alloverCommerce.addFirstName.sendKeys
                (ConfigReader.getProperty("customarFirstNameForBillingAddress"), Keys.TAB,
                        ConfigReader.getProperty("customarLastNameForBillingAddress"), Keys.TAB, Keys.TAB);
        extentTest.info("Negatif Test için Fatura adresi isim ve soy ismi boş bırakıldı");
        //Enter dropdown also select country
        actions.sendKeys("(us)", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Ülke United States (US)girildi.");
        alloverCommerce.addFirstName.clear();
        alloverCommerce.addLastName.clear();
        //Enter the Street address
        ReusableMethods.visibleWait(alloverCommerce.addHouseNumberAndStreetName, 15);
        alloverCommerce.addHouseNumberAndStreetName.sendKeys
                (ConfigReader.getProperty("Street"), Keys.TAB, Keys.TAB,
                        ConfigReader.getProperty("City"), Keys.TAB);
        extentTest.info("Street ismi girildi.");
        //Enter the dropdown should also be able to select the States
        actions.sendKeys("yor", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("State Ney York seçildi.");
        //Enter the "ZIP/Code"
        alloverCommerce.addBillingPostCode.clear();
        alloverCommerce.addBillingPostCode.sendKeys
                //Don't enter the Phone Number
                // Verify that the "SAVE ADDRESS" Button has been clicked
                        (ConfigReader.getProperty("PostCode"), Keys.TAB, Keys.DELETE, Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("Posta kodu girildi negatif test için telefon numarası boş bırakıldı");
        //The address has been successfully changed or not Verify that "must see" appears
        Assert.assertFalse(alloverCommerce.theErrorMessage.getText().contains("Address changed successfully"));
        extentTest.info("Adres Başarılı bir şekilde değişti ifadesi çıkmadı.");
        //Close web browser
        Driver.closeDriver();
        extentTest.info("Web browser kapatıldı.");
        extentReports.flush();

    }
}
