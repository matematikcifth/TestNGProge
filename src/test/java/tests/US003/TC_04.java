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

public class TC_04 extends ExtentReport {
    @Test
    public void testName() {
        extentTest = extentReports.createTest("Esen" , "Allovercommerce Test Edebilmeli");

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
        extentTest.info("Hesabım bölümüne tıklandı");

        //Make sure that user see the "Addresses" and Click the "Addresses
        Assert.assertTrue(page.addressesButton.isDisplayed());
        page.addressesButton.click();
        extentTest.info("Adres bölümünün görüldüğü kontrol edildi ve tıklandı");

        //Click the billing address "Edit" button under the billing address
        WebElement yazi =page.editBillingAddress;
        ReusableMethods.scroll(yazi);
        ReusableMethods.bekle(2);
        page.editBillingAddress.click();
        extentTest.info("Fatura Adresi bölümünün altındaki edit butonuna tıklandı");

        //check your first name on "First name * " section
        ReusableMethods.bekle(2);
        String ddmFirstName = ReusableMethods.getValueByJS("billing_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("US03name"),ddmFirstName);
        extentTest.info("İsim kısmının otomatik ve doğru olarak doldurulduğu test edildi");

        //check your lastname on "Last name * " section
        String ddmLastName = ReusableMethods.getValueByJS("billing_last_name","value");
        Assert.assertEquals(ConfigReader.getProperty("US03lastname"),ddmLastName);
        extentTest.info("Soyisim kısmının otomatik ve doğru olarak doldurulduğu test edildi");

        //enter your street addres on "Street address " section
        //enter your town  on "Town/City" section
        //enter your Zip Code on "Postcode/Zip*" section
        //enter your Phone number  on "Phone*" section
        page.billingStreetBox.sendKeys("Elm Street", Keys.TAB, Keys.TAB, "qwerty",
                Keys.TAB, Keys.TAB+ "1234", Keys.TAB, "123456789");
        extentTest.info("Adres bilgileri ve Telefon Numarası girildi");

        //Select your contry/region on "Country/Region *" selection
        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Australia");
        extentTest.info("Ülke bilgileri girildi");

        //select your State on "State *" section
        WebElement stateSelect = page.billingStateSelect;
        Select select1 = new Select(stateSelect);
        select1.selectByIndex(4);
        ReusableMethods.bekle(2);
        extentTest.info("Eyalet seçildi");

        //email address section was cleared
        WebElement savedBillingEmailBox = page.billingEmailBox;
        savedBillingEmailBox.clear();
        extentTest.info("E-mail adresi bölümü boşaltıldı");

        //Click the "SAVE ADDRESS" button
        WebElement saveAddress = page.billingSubmit;
        ReusableMethods.click(saveAddress);
        ReusableMethods.bekle(2);
        extentTest.info("Adresi Kaydet butonuna tıklandı");

        //Make sure that user can see the "Mistake Message." after click the save address button
        ReusableMethods.visibleWait(page.billingEmailBoxAlert, 10);
        Assert.assertTrue(page.billingEmailBoxAlert.isDisplayed());
        extentTest.info("Adresi Kaydet kutusuna tıkladıktan sonra hata mesajının geldiğini kontrol et");

        extentTest.pass("Kontrol Edildi");
        extentReports.flush();
    }
}
