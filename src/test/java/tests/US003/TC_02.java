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

public class TC_02 extends ExtentReport {
    @Test
    public void TC_02() {
        extentTest = extentReports.createTest("Esen" , "Allovercommerce Test Edilebilmeli");

//    go to the website
        Driver.getDriver().get(ConfigReader.getProperty("alloverceUrl"));
        extentTest.info("Sayfaya Gidildi");

//    Sing in your account
        Allover_Commerce_Page page = new Allover_Commerce_Page();
        page.singIn.click();
        page.userName.sendKeys(ConfigReader.getProperty("email"),
                Keys.TAB, ConfigReader.getProperty("password"), Keys.TAB, Keys.ENTER);
        extentTest.info("Giriş yapıldı.");

//    Go to "myAccount"
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.myAccountButton);
        extentTest.info("Hesabım butonuna tıklandı");

//    Make sure that user see the "Addresses" and Click the "Addresses
        Assert.assertTrue(page.addressesButton.isDisplayed());
        page.addressesButton.click();
        extentTest.info("Adres butonunu gördüğümüzden emin olduk ve tıkladık");

//    Click the billing address "Edit" button under the billing address
        WebElement yazi =page.editBillingAddress;
        ReusableMethods.scroll(yazi);
        ReusableMethods.bekle(2);
        page.editBillingAddress.click();
        extentTest.info("Adres bölümünün altındaki 'Edit' butonuna tıklandı");

//    Clear your first name on "First name * " section
        WebElement nameBox= page.billingFirstNameBox;
        nameBox.clear();
        extentTest.info("İsim kutucuğu temizlendi");


//    clear your lastname on "Last name * " section
        WebElement lastNameBox= page.billingLastNameBox;
        lastNameBox.clear();
        extentTest.info("Soyisim kutucuğu temizlendi");

//    clear your street addres on "Street address " section
        WebElement savedBillingStreetBox=page.billingStreetBox;
        savedBillingStreetBox.clear();
        extentTest.info("Adres bölümünü temizlendi");

//    clear your town  on "Town/City" section
        WebElement savedTownBox=page.billingCityTownBox;
        savedTownBox.clear();
        extentTest.info("Şehir/Kasaba bölümü temizlendi");

//    clear your Zip Code on "Postcode/Zip*" section
        WebElement zipCodeNumber=page.billingPostCodeBox;
        ReusableMethods.scroll(zipCodeNumber);
        zipCodeNumber.clear();
        extentTest.info("Posta Kodu bölümü temizlendi");

        //clear your Phone number  on "Phone*" section
        WebElement savedPhoneNumber=page.billingPhoneBox;
        ReusableMethods.scroll(savedPhoneNumber);
        savedPhoneNumber.clear();
        extentTest.info("Telefon Numarası bölümü temizlendi");

        //Make sure that the email address section is already fill out
        String ddm = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),ddm);
        extentTest.info("E-mail adresi bölümünün otomatik doldurulduğundan emin olduk");

        //Click the "SAVE ADDRESS" button
        WebElement saveAddress = page.billingSubmit;
        ReusableMethods.click(saveAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet Butonuna tıklandı");

        //Make sure that user can see the "Mistake Message." after click the save address button
        ReusableMethods.visibleWait(page.billingFirstNameAlert, 10);
        Assert.assertTrue(page.billingFirstNameAlert.isDisplayed());
        Assert.assertTrue(page.billingLastNameAlert.isDisplayed());
        Assert.assertTrue(page.billingStreetAdresAlert.isDisplayed());
        Assert.assertTrue(page.billingTownCityAlert.isDisplayed());
        Assert.assertTrue(page.billingPhoneNumberAlert.isDisplayed());
        Assert.assertTrue(page.billingPostCodeBox.isDisplayed());
        extentTest.info("Hata  Mesajlarının geldiği kontrol edildi");


        extentTest.pass("Kontrol edildi");
        extentReports.flush();
    }
}
