package tests.US003;

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

public class TC_03 extends ExtentReport{

    @Test
    public void test03() {
        extentTest = extentReports.createTest("Esen", "Allovercommerce Test Edebilmeli");

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
        extentTest.info("Adres bölümünün görüldüğü test edildi ve tıklandı");

        //Click the billing address "Edit" button under the billing address
        WebElement yazi = page.editBillingAddress;
        ReusableMethods.scroll(yazi);
        ReusableMethods.bekle(2);
        page.editBillingAddress.click();
        extentTest.info("Billing Address bölümünün altındaki Edit butonuna tıklandı");

        //Check your first name on "First name" section
        String ddmFirstName = ReusableMethods.getValueByJS("billing_first_name", "value");
        Assert.assertEquals(ConfigReader.getProperty("US03name"), ddmFirstName);
        extentTest.info("İsim Kutusunun otomatik olarak doğru bir şekilde doldurulduğu kontrol edildi");

        //Check your lastname on "Last name" section
        String ddmLastName = ReusableMethods.getValueByJS("billing_last_name", "value");
        Assert.assertEquals(ConfigReader.getProperty("US03lastname"), ddmLastName);
        extentTest.info("Soyisim kutusunun doğru bir şekilde doldurulduğu kontrol edildi");

        //Select your contry/region on "Country/Region *" selection
        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Australia");
        extentTest.info("Ülke seçimi yapıldı");

        //enter street addres on "Street address " section
        //enter town  on "Town/City" section
        //enter Zip Code on "Postcode/Zip*" section
        //enter Phone number  with letters on "Phone Number" section
        page.billingStreetBox.sendKeys("abc", Keys.TAB, Keys.TAB, "abcde",
                Keys.TAB, Keys.TAB + "1234", Keys.TAB, "abc");
        extentTest.info("Telefon numarası kısmına harf girişi yapıldı");

        //select your State on "State *" section
        WebElement stateSelect = page.billingStateSelect;
        Select select1 = new Select(stateSelect);
        select1.selectByIndex(4);
        ReusableMethods.bekle(2);
        extentTest.info("Eyalet bilgileri girildi");

        //Make sure that the email address section is already fill out
        String ddm = ReusableMethods.getValueByJS("billing_email", "value");
        Assert.assertEquals(ConfigReader.getProperty("email"), ddm);
        extentTest.info("E-mail adresi bölümünün otomatik olarak doğru bir şekilde doldurulduğunu kontrol edildi");

        //Click the "SAVE ADDRESS" button
        WebElement saveAddress = page.billingSubmit;
        ReusableMethods.click(saveAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet butonuna tıklandı");

        //Make sure that user can see the "Mistake Report" after click the save address button
        ReusableMethods.visibleWait(page.billingPhoneAlertTC03, 10);
        Assert.assertTrue(page.billingPhoneAlertTC03.isDisplayed());
        extentTest.info("Telefon Bölümüne harf girilmesi hatasının görüldüğü test edildi");

        extentTest.pass("Kontrol edildi");
        extentReports.flush();
    }

}

