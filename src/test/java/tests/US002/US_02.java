package tests.US002;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
//import org.testng.Assert;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class US_02 extends ExtentReport {

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    /**
     Kayıtlı bir Username girilmeli
     Kayıtlı bir e-mail adresi girilmeli  (abc@abc.com formatında e mail adresi olmalı)
     Password girilebilmelidir. (Parola en az 12 karakter uzunluğunda olmalıdır.
     Daha güçlü hale getirmek için büyük ve küçük harfler, sayılar ve ! " ? $ % ^ & kullanılmalıdır. )
     SIGN UP butonuna tıklanmalı (Username, Email address ve Password girilmeden SIGN UP butonu tıklanabilir olmamalı)
     "An account is already registered with your email address." uyarı metni ve "Please log in." görülmeli
     */

    @Test
    public void test01() {

        // Positive TestCase 1
        // Register islemi basarili sekilde yapilmali
        extentTest = extentReports.createTest("Ayse","Allovercommerce US_02-Test_01");
        Faker faker = new Faker();
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        alloverCommercePage.register.click();
        extentTest.info("Allovercommerce sayfasina gidildi");

        String userName = faker.name().fullName();
        System.out.println("userName : "+userName);
        alloverCommercePage.usernameAyse.sendKeys(userName, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("Username girildi");

        String email = faker.internet().emailAddress();
        System.out.println("email : "+email);
        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        extentTest.info("Email girildi");

        String password = "Test123456!";
        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        extentTest.info("Policy kutucuguna tiklandi");

        alloverCommercePage.signUpButton.click();
        extentTest.info("Sign Up butonuna tiklandi");

        Assert.assertTrue(alloverCommercePage.signOutButton.isDisplayed(), "Verify successfully registered");
        extentTest.info("Basarili bir giris yapildigi dogrulandi");

        // Registration sayfasina yeniden giris yapilmali ve
        //"An account is already registered with your email address." mesaji alinmali

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        alloverCommercePage.register.click();
        ReusableMethods.bekle(2);
        extentTest.info("Allovercommerce sayfasina tekrar gidildi ve register butonuna tiklandi");

        userName = faker.name().fullName();
        alloverCommercePage.usernameAyse.sendKeys(userName, Keys.ENTER);
        System.out.println("userName : "+userName);
        extentTest.info("Yeni bir username girildi");
        ReusableMethods.bekle(2);


        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        System.out.println("email : "+email);
        extentTest.info("Daha once kayitli bir email girildi");

        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        alloverCommercePage.signUpButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Policy ve sign up tiklandi");

        //An account is already registered with your email address." uyarı metni alinmali
        String expectedErrorMessage = "An account is already registered with your email address.";
        String actualErrorMessage = alloverCommercePage.errorMessage.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        ReusableMethods.bekle(2);
        extentTest.info("Kayitli bir email ile giris yapilamadigi dogrulandi");


        //"Please log in." mesaji görülmeli
        Assert.assertTrue(alloverCommercePage.pleaseLogin.isDisplayed());
        extentTest.info("\"Please log in\" mesajinin gorundugu dogrulandi");

    }

    @Test
    public void test02() {

        /**
         * Kayıtlı bir Username girilmeli
         * Yeni bir e-mail adresi girilmeli
         * Password girilmeli
         * SIGN UP butonuna tıklanmalı
         * "An account is already registered with that username. Please choose another." uyarı metni görülmeli
         */

        // Negative TestCase 1
        // Register islemi basarili sekilde yapilmali
        extentTest = extentReports.createTest("Ayse","Allovercommerce US_02-Test_02");
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();
        alloverCommercePage.register.click();
        Faker faker = new Faker();
        extentTest.info("Allovercommerce sayfasina tekrar gidildi ve register butonuna tiklandi");

        String userName = faker.name().fullName();
        alloverCommercePage.usernameAyse.sendKeys(userName,Keys.ENTER);
        extentTest.info("Username girildi");

        String email = faker.internet().emailAddress();
        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        extentTest.info("Email girildi");

        String password = "Test123456!";
        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        alloverCommercePage.signUpButton.click();
        extentTest.info("Policy ve sign up tiklandi");

        Assert.assertTrue(alloverCommercePage.signOutButton.isDisplayed(), "Verify successfully registered");
        extentTest.info("Basarili bir giris yapildigi dogrulandi");

        //  Kayıtlı bir Username , password ve yeni bir e-mail adresi ile yeniden giris yapilmali ve
        //"An account is already registered with that username. Please choose another." mesaji alinmali

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        alloverCommercePage.register.click();
        extentTest.info("Allovercommerce sayfasina gidildi ve register butonuna tiklandi");

        alloverCommercePage.usernameAyse.sendKeys(userName,Keys.ENTER);
        extentTest.info("Daha once kayitli bir username girildi");
        ReusableMethods.bekle(2);

        email = faker.internet().emailAddress();
        alloverCommercePage.emailAyse.sendKeys(email,Keys.ENTER);
        extentTest.info("Yeni bir email girildi");
        ReusableMethods.bekle(2);

        alloverCommercePage.passwordAyse.sendKeys(password,Keys.ENTER);
        extentTest.info("Password girildi");

        alloverCommercePage.policy.click();
        alloverCommercePage.signUpButton.click();
        extentTest.info("Policy ve sign up tiklandi");

        String actualErrorMessage = alloverCommercePage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        String expectedErrorMessage = "An account is already registered with that username. Please choose another.";
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
        extentTest.info("Kayitli bir username ile giris yapilamadigi dogrulandi");

    }

}


