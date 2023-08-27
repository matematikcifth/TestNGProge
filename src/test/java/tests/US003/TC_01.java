package tests.US003;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.*;

public class TC_01 extends ExtentReport {
    @Test
    public void testName() {
        extentTest = extentReports.createTest("Esen" , "Allovercommerce Test Edilebilmeli");

        //go to the website
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //Sing in your account
        Allover_Commerce_Page page = new Allover_Commerce_Page();
        page.singIn.click();
        page.userName.sendKeys(ConfigReader.getProperty("email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.TAB, Keys.ENTER);
        extentTest.info("Giriş yapıldı.");

        //Go to "myAccount"
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.myAccountButton);
        extentTest.info("Hesabım bölümüne girildi");

        //Make sure that user see the "Addresses" and Click the "Addresses
        Assert.assertTrue(page.addressesButton.isDisplayed());
        page.addressesButton.click();
        extentTest.info("Adres bölümünün görüldüğünden emin olup tıkladı");

        //Click the billing address "Edit" button under the billing address
        WebElement yazi =page.editBillingAddress;
        ReusableMethods.scroll(yazi);
        ReusableMethods.bekle(2);
        page.editBillingAddress.click();
        extentTest.info("Billing Address bölümünün altındaki Edit bölümüne tıklandı");

        // check yor first name on "First name * " section
        String ddmFirstName = ReusableMethods.getValueByJS("billing_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("US03name"),ddmFirstName);
        extentTest.info("İsim kutusuna ismin otomatik olarak geldiği kontrol edildi");

        //check your lastname on "Last name * " section
        String ddmLastName = ReusableMethods.getValueByJS("billing_last_name","value");
        Assert.assertEquals(ConfigReader.getProperty("US03lastname"),ddmLastName);
        extentTest.info("Soyisim kutusuna soyismin otomatik olarak geldiği kontrol edildi");


        //enter your street addres on "Street address " section
        //enter your town  on "Town/City" section
        //enter your Zip Code on "Postcode/Zip*" section
        //enter your Phone number  on "Phone*" section
        page.billingStreetBox.sendKeys("", Keys.TAB, Keys.TAB, "",
                Keys.TAB, Keys.TAB+ "1234", Keys.TAB, "123456789");
        extentTest.info("Adres bilgileri ve Telefon Numarası girişi yapıldı");

        //Select your contry/region on "Country/Region *" selection
        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Australia");
        extentTest.info("Ülke seçimi yapıldı");

        //select your State on "State *" section
        WebElement stateSelect = page.billingStateSelect;
        Select select1 = new Select(stateSelect);
        select1.selectByIndex(4);
        ReusableMethods.bekle(2);
        extentTest.info("Eyalet seçimi yapıldı");

        //Make sure that the email address section is already fill out
        String ddm = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),ddm);
        extentTest.info("Email adresini bölümünün otomatik olarak doldurulduğunu kontrol edin");

//    Click the "SAVE ADDRESS" button
        WebElement saveAddress = page.billingSubmit;
        ReusableMethods.click(saveAddress);
        ReusableMethods.bekle(2);
        extentTest.info("'Save Addresss' bölümüne tıklayın");

//    Make sure that user can see the "Address changed successfully." after click the save address button
        ReusableMethods.visibleWait(page.billingAllert, 10);
        Assert.assertTrue(page.billingAllert.getText().contains("Address changed successfully."));
        extentTest.info("Adres başarıyla değiştirildi yazısı görüldü");

       // extentTest.pass("Kontrol Edildi");
       // extentReports.flush();
    }
}
