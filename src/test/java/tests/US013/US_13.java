package tests.US013;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US_13 extends ExtentReport {
    @Test
    public void testTC01() {
        extentTest=extentReports.createTest("M.Ali_US_13/TC01_PozitiveTest", "Allover_Commerce Test edilebilmeli.");
        //US_13/TC01
        //Login as a "Vendor".
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Url'e gidildi.");
        Allover_Commerce_Page alloverCommerce = new Allover_Commerce_Page();
        alloverCommerce.singin.click();
        ReusableMethods.bekle(2);
        alloverCommerce.emailAyse.sendKeys
                (ConfigReader.getProperty("vendorEmail2"), Keys.TAB,
                        ConfigReader.getProperty("vendorPassword2"), Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor olarak giriş yapıldı");
        //Scroll down the page until you see 'My account't and click.
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(5);
        alloverCommerce.myAccount1.click();
        extentTest.info("Sayfanın en altına inilip My Account tıklandı");
        //Click 'My Addresses'
        ReusableMethods.visibleWait(alloverCommerce.Addresses, 15);
        alloverCommerce.Addresses.click();
        ReusableMethods.bekle(3);
        extentTest.info("Addresses buttonu tıklandı, adreslerim alanına girildi.");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Mouse over the 'GETEDITsIPPINGADDRESS' link under Shipping Address and click.
        ReusableMethods.visibleWait(alloverCommerce.getEditShippingAddress, 15);
        alloverCommerce.getEditShippingAddress.click();
        extentTest.info("Teslimat addresi alanına girildi.");
        //Enter your name in the "First Name" and "Last Name" field.
        alloverCommerce.addShippingFirstName.clear();
        alloverCommerce.addShippingFirstName.sendKeys
                (ConfigReader.getProperty("customarFirstName"), Keys.TAB,
                        ConfigReader.getProperty("customarLastName"), Keys.TAB, Keys.TAB);
        extentTest.info("İlgili alana teslimat için isim soy isim girildi");
        //Enter Country in the "Country /Region" field and select the Country that //appears.
        actions.sendKeys("fra", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Ddm den teslimat adresi için ülke seçimi yapıldı.");
        //Enter Address in the Street Address field
        alloverCommerce.addShippingStreet.sendKeys
                (ConfigReader.getProperty("customarShippingStreet"), Keys.TAB, Keys.TAB,
                        //Enter ZIP Code in the ZIP Code field
                        ConfigReader.getProperty("customarShippingPostCode"), Keys.TAB,
                        //Enter Town/City in the Town/City field
                        //Click to 'Save Address' button
                        ConfigReader.getProperty("customarShippingCity"), Keys.TAB, Keys.ENTER);
        extentTest.info("Teslimat addresi alanına sokak ismi, posta kodu, şehir girildi.");
        extentTest.info("Save Address buttonuna basıldı");

        //"Address changed successfully." Verify that the message appears.
        Assert.assertTrue(alloverCommerce.shippingAddressChanged.getText().contains("Address changed successfully"));
        extentTest.info("Address changed successfully ifadesinin ekranda çıktığı doğrulandı ");
        //Close web browser
        Driver.closeDriver();
        extentTest.info("Web browser kapatıldı");
        extentReports.flush();


    }

    @Test
    public void testTC02() {
        extentTest=extentReports.createTest("M.Ali_US_13/TC02_NegativeTest", "Allover_Commerce Test edilebilmeli.");
        //Login as a "Vendor".
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Url'e gidildi.");
        Allover_Commerce_Page alloverCommerce = new Allover_Commerce_Page();
        alloverCommerce.singin.click();
        ReusableMethods.bekle(2);
        alloverCommerce.emailAyse.sendKeys
                (ConfigReader.getProperty("vendorEmail2"), Keys.TAB,
                        ConfigReader.getProperty("vendorPassword2"), Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor olarak giriş yapıldı");
        //Scroll down the page until you see 'My account't and click.
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(5);
        alloverCommerce.myAccount1.click();
        extentTest.info("Sayfanın en altına inilip My Account tıklandı");
        //Click 'My Addresses'
        ReusableMethods.visibleWait(alloverCommerce.Addresses, 15);
        alloverCommerce.Addresses.click();
        ReusableMethods.bekle(3);
        extentTest.info("Addresses buttonu tıklandı, adreslerim alanına girildi.");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Mouse over the 'ADD' link under Shipping Address and click when //underlined.
        ReusableMethods.visibleWait(alloverCommerce.getEditShippingAddress, 15);
        alloverCommerce.getEditShippingAddress.click();
        //Don't enter customar Name and  negative test.
        alloverCommerce.addShippingFirstName.clear();
        alloverCommerce.addShippingLastName.sendKeys
                (ConfigReader.getProperty("customarLastName"), Keys.TAB, Keys.TAB);
        extentTest.info("Negatif test için teslimat adresi isim  alanı boş bırakıldı.");
        //Enter Country in the "Country /Region" field and select the Country that //appears.
        actions.sendKeys("fra", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Teslimat adresi için ülke Fransa seçildi.");
        //Enter Address in the Street Address field
        alloverCommerce.addShippingStreet.sendKeys
                (ConfigReader.getProperty("customarShippingStreet"), Keys.TAB, Keys.TAB,
                        //Enter ZIP Code in the ZIP Code field
                        ConfigReader.getProperty("customarShippingPostCode"), Keys.TAB,
                        //Enter Town/City in the Town/City field
                        //Click to 'Save Address' button
                        ConfigReader.getProperty("customarShippingCity"), Keys.TAB, Keys.ENTER);
        extentTest.info("Teslimat adresi için sokak, postakodu ve şehir ismi girildi.");
        //"Address changed successfully." Verify that the message appears or not.
        Assert.assertFalse(alloverCommerce.theErrorMessage.getText().contains("Address changed successfully"));
        extentTest.info("İsim soy isim alanları boş kalınca Başarılı bir şekilde adres değişti ifadesinin çıkmadığı doğrulandı.");

        //Close web browser
        Driver.closeDriver();
        extentTest.info("Web browser kapatıldı");
        extentReports.flush();


    }

    @Test
    public void testTC03() {
        extentTest=extentReports.createTest("M.Ali_US_13/TC03_NegativeTest", "Allover_Commerce Test edilebilmeli.");
        //Login as a "Vendor".
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("URL'e gidildi");
        Allover_Commerce_Page alloverCommerce = new Allover_Commerce_Page();
        alloverCommerce.singin.click();
        ReusableMethods.bekle(2);
        alloverCommerce.emailAyse.sendKeys
                (ConfigReader.getProperty("vendorEmail2"), Keys.TAB,
                        ConfigReader.getProperty("vendorPassword2"), Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor olarak giriş yapıldı");
        //Scroll down the page until you see 'My account't and click.
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(5);
        alloverCommerce.myAccount1.click();
        extentTest.info("Sayfada en alta inildi My Account tıklandı");
        //Click 'My Addresses'
        ReusableMethods.visibleWait(alloverCommerce.Addresses, 15);
        alloverCommerce.Addresses.click();
        ReusableMethods.bekle(3);
        extentTest.info("Adreslerim alanı tıklandı");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //Mouse over the 'ADD' link under Shipping Address and click when //underlined.
        ReusableMethods.visibleWait(alloverCommerce.getEditShippingAddress, 15);
        alloverCommerce.getEditShippingAddress.click();
        extentTest.info("getEditShippingAddress tıklandı");
        //Enter your name in the "First Name" and don't enter"Last Name".
        alloverCommerce.addShippingFirstName.clear();
        alloverCommerce.addShippingFirstName.sendKeys
                (ConfigReader.getProperty("customarFirstName"), Keys.TAB, Keys.TAB);
        alloverCommerce.addShippingLastName.clear();
        extentTest.info("Soyisim boş bırakıldı");
        //Enter Country in the "Country /Region" field and select the Country that //appears.
        actions.sendKeys("fra", Keys.ENTER, Keys.TAB, Keys.CLEAR).perform();
        extentTest.info("Teslimat adrsinde ülke seçimi yapıldı");
        //Enter Address in the Street Address field
        alloverCommerce.addShippingStreet.sendKeys
                (ConfigReader.getProperty("customarShippingStreet"), Keys.TAB, Keys.TAB,
                        //Enter ZIP Code in the ZIP Code field
                        ConfigReader.getProperty("customarShippingPostCode"), Keys.TAB,
                        //Enter Town/City in the Town/City field
                        //Click to 'Save Address' button
                        ConfigReader.getProperty("customarShippingCity"), Keys.TAB, Keys.ENTER);
        extentTest.info("Sokak, Posta kodu, şehir ismi girildi.");
        extentTest.info("Save Address buttonuna basıldı");
        //"Address changed successfully." Verify that the message appears or not.
        Assert.assertFalse(alloverCommerce.theErrorMessage.getText().contains("Address changed successfully"));
        extentTest.info("Soyisim boş bırakıldığı için teslimat adresi başarıyla değişti mesajı görülmedi.");
        //Close web browser
        Driver.closeDriver();
        extentTest.info("Browser kapatıldı.");
        extentReports.flush();

    }
}
