package tests.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US_01 extends ExtentReport {

    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }

    /**
     Username girilmeli (Küçük harf, büyük harf, rakam ve özel karakter içerebilmeli)
     e-mail adresi girilmeli (abc@abc.com formatında e mail adresi olmalı)
     Password girilebilmelidir. (Parola en az 12 karakter uzunluğunda olmalıdır.
     Daha güçlü hale getirmek için büyük ve küçük harfler, sayılar ve ! " ? $ % ^ & kullanılmalıdır. )
     "I agree to the privacy policy" tıklanmadan kayıt olunmamalı
     SIGN UP butonu tıklanabilir olmalı (Username, Email address ve Password girilmeden SIGN UP tıklandığında kayıt işlemi gerçekleşmemeli)

     */

    @Test
    public void test01() {

        // Positive TestCase 1
        //SİGN UP butonuna basarili bir sekilde tıklar

        extentTest = extentReports.createTest("Ayse","Allovercommerce US_01-Test_01");
        Faker faker = new Faker();
        Allover_Commerce_Page allover_commerce_page = new Allover_Commerce_Page();
        extentTest.info("Allovercommerce sayfasina gidildi");

        allover_commerce_page.register.click();

        String userName = faker.name().fullName();
        allover_commerce_page.usernameAyse.sendKeys(userName, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("Username girildi");

        String email = faker.internet().emailAddress();
        System.out.println(email);
        allover_commerce_page.emailAyse.sendKeys(email, Keys.ENTER);
        extentTest.info("Email girildi");

        String password = "Test123456!";
        allover_commerce_page.passwordAyse.sendKeys(password, Keys.ENTER);
        extentTest.info("Password girildi");

        allover_commerce_page.policy.click();
        extentTest.info("Policy kutucuguna tiklandi");

        allover_commerce_page.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");

        Assert.assertTrue(allover_commerce_page.signOutButton.isDisplayed(), "Verify successfully registered");
        extentTest.info("Basarili bir giris yapildigi dogrulandi");

    }

    @Test
    public void test02() {

        // Positive TestCase 2
        //"I agree to the privacy policy" tıklanmadan kayıt olunmamalı
        //"Please tick this box if you want to proceed." yani , İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrular
        extentTest = extentReports.createTest("Ayse","Allovercommerce US_01-Test_02");
        Faker faker = new Faker();
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        alloverCommercePage.register.click();
        extentTest.info("Allovercommerce sayfasina gidildi ve register butonuna tiklandi");

        String userName = faker.name().fullName();
        alloverCommercePage.usernameAyse.sendKeys(userName, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("Username girildi");

        String email = faker.internet().emailAddress();
        System.out.println(email);
        alloverCommercePage.emailAyse.sendKeys(email, Keys.ENTER);
        extentTest.info("Email girildi");



        String password = "Test123456!";
        alloverCommercePage.passwordAyse.sendKeys(password, Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.signUpButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Sign Up butonuna tiklandi");

        String actualPolicyValidationMessage = alloverCommercePage.policy.getAttribute("validationMessage");
        System.out.println("Policy Validation Message = " + actualPolicyValidationMessage);
        String expectedPolicyValidationMessage = "Please tick this box if you want to proceed.";
        extentTest.info("Policy kutucugu tiklanmadi");

        Assert.assertTrue(actualPolicyValidationMessage.contains(expectedPolicyValidationMessage));
        ReusableMethods.bekle(3);
        extentTest.info("Please tick this box if you want to proceed, mesaji alindi ve giris yapilamadi");

    }

    @Test
    public void test03() {
        // Negative TestCase 1
        // Username bos gonderildiginde "Please fill in this field." mesaji alinmali
        extentTest = extentReports.createTest("Ayse","Allovercommerce US_01-Test_03");
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        alloverCommercePage.register.click();
        Faker faker = new Faker();
        extentTest.info("Allovercommerce sayfasina gidildi ve register butonuna tiklandi");

        String email = faker.internet().emailAddress();
        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        extentTest.info("Email girildi");

        String password = "Test123456!";
        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        alloverCommercePage.signUpButton.click();
        extentTest.info("Policy yazan kutucuk tiklandi");

        String actualUsernameValidationMessage = alloverCommercePage.usernameAyse.getAttribute("validationMessage");
        System.out.println("Username Validation Message = " + actualUsernameValidationMessage);
        String expectedUsernameValidationMessage = "Please fill in this field.";
        extentTest.info("Username girilmedigi icin uyari mesaji alindi");

        Assert.assertTrue(actualUsernameValidationMessage.contains(expectedUsernameValidationMessage));
        extentTest.info("Username bos birakildiginda giris yapilamadigi dogrulandi");

        ReusableMethods.bekle(2);



    }

    @Test
    public void test04() {
        // Negative TestCase 2
        // Email "ss@ho" bu sekilde girildiginde "Please provide a valid email address" mesaji alinmali
        extentTest = extentReports.createTest("Ayse","Allovercommerce US_01-Test_04");
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        alloverCommercePage.register.click();
        Faker faker = new Faker();
        extentTest.info("Allovercommerce sayfasina gidildi ve register butonuna tiklandi");

        String userName = faker.name().fullName();
        alloverCommercePage.usernameAyse.sendKeys(userName,Keys.ENTER);
        extentTest.info("Username girildi");

        String email = "ss@ho";
        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        extentTest.info("Gecersiz bir email girildi");

        String password = "Test123456!";
        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        alloverCommercePage.signUpButton.click();
        extentTest.info("Policy ve sign up tiklandi");


        String expectedMessage = "Please provide a valid email address";
        String actualMessage = alloverCommercePage.errorMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        System.out.println("actualMessage = " + actualMessage);  // actualMessage = Please provide a valid email address.
        extentTest.info("Yanlis email ile giris yapilamadigi dogrulandi");

        ReusableMethods.bekle(2);


    }
}

