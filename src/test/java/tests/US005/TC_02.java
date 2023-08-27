package tests.US005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;



public class TC_02 extends ExtentReport {

    //HomePage'e git.
    //Oturum aç düğmesine tıklayın.
    //E-postanızı girin.
    //Şifrenizi girin.
    //"Oturum aç" düğmesini tıklayın.
    //Başarılı bir şekilde giriş yaptığınızı doğrulayın.
    //"Başarılarım" düğmesi görünene kadar sayfayı aşağı kaydırın.
    //"Hesabım" düğmesini tıklayın.
    //"Hesabım" sayfasında olduğunuzu doğrulayın.
    //"Hesabınızı düzenleyin ve Ayrıntılara Bakın" düğmesini tıklayın.
    //"Hesap Ayrıntıları" sayfasında olduğunuzu doğrulayın.
    //Hesap ayrıntılarını değiştirme
    //Adını girin
    //Soyadı girin
    //Görüntülü ad girin
    //Yeni e-postanızı girin
    //Biyografi kutusuna tıklayın
    //Biyografi kutusuna "LIFE İS SO BEAUTIFUL" mesajı yazın
    //Mesajın görüntülenmesini doğrulayın
    //"Şifre değişikliği" yapısının görüntülenmesini doğrulayın
    //Geçerli şifreyi girin
    //Yeni şifre girin
    //"Değişimi kaydet" düğmesini tıklayın
    //"Hesap ayrıntıları başarıyla değiştirildi" mesajını doğrulayın"

    @Test
    public void test02() {

        extentTest = extentReports.createTest("Esma" , "Allovercommerce Test Edebilmeli");

        //Go to homePage
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //Click on "sign in" button
        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();

        alloverCommercePage.signIn.click();

        ReusableMethods.bekle(2);

        alloverCommercePage.usernameAyse.sendKeys(ConfigReader.getProperty("email"), Keys.TAB,
                ConfigReader.getProperty("password"));
        alloverCommercePage.signInButton.submit();

        ReusableMethods.bekle(2);
        extentTest.info("Giriş yapıldı");

        //Verify you login successfully
        Assert.assertTrue(alloverCommercePage.welcomeAllover.isDisplayed());

        ReusableMethods.bekle(2);

        //Scroll down the page until "My Accout" button is visible
        //Click on "my account" button
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE, Keys.SPACE).perform();

        ReusableMethods.bekle(4);

        Assert.assertTrue(alloverCommercePage.myAccount.isDisplayed());
        extentTest.info("Hesabim yazisi göründü");

        alloverCommercePage.accountbutton.click();
        extentTest.info("Hesabim yazisina tiklandi");

        //Verify you are in"My Account" page
        Assert.assertTrue(alloverCommercePage.accounttaOldugunuDogrula.isDisplayed());
        extentTest.info("Hesabimda oldugum dogrulandi");

        //Click on "Edit your account and Account Details" button
        //Verify you are in" Account Details" page
        ReusableMethods.bekle(5);

        alloverCommercePage.accountDetailsButton.click();
        extentTest.info("Account Details tiklandi");

        Assert.assertTrue(alloverCommercePage.accountDetailsDogrula.isDisplayed());
        extentTest.info("Account Details oldugum dogrulandi");

        //Change account Details
        //Enter first name
        //Enter last name
        //Enter display name
        //Enter your new email--degistirilmedi(teamde ortak kullanimda)
        ReusableMethods.bekle(4);

        alloverCommercePage.firstName.clear();
        alloverCommercePage.firstName.sendKeys("lale");
        extentTest.info("First Name eklendi");

        alloverCommercePage.lastName.clear();
        alloverCommercePage.lastName.sendKeys("lalezar");
        extentTest.info("Last Name eklendi");

        alloverCommercePage.displayName.clear();
        alloverCommercePage.displayName.sendKeys("lal");
        extentTest.info("Display Name eklendi");

        ReusableMethods.bekle(5);



        //Click on biography box
        Driver.getDriver().switchTo().frame(alloverCommercePage.biographyBox);
        extentTest.info("Biography Box tiklandi");

        //Type "LIFE İS SO BEAUTIFUL" message in biography box
        //Verify displaying of message
        alloverCommercePage.biographyBoxYazilacakYer.sendKeys("LIFE İS SO BEAUTIFUL");
        extentTest.info("LIFE İS SO BEAUTIFUL eklendi");

        ReusableMethods.bekle(3);

        Driver.getDriver().switchTo().parentFrame(); //frame degistirildi

        ReusableMethods.bekle(3);

        //Verify displaying of "password change" structure
        Assert.assertTrue(alloverCommercePage.PasswordChangeYazisi.isDisplayed());
        extentTest.info("password change yazisi göründü");



        //HATALI KISIM

        //Enter current password
        //Enter new password
        alloverCommercePage.currentPassword.sendKeys(ConfigReader.getProperty("password"), Keys.TAB,ConfigReader.getProperty("password"));
        alloverCommercePage.saveChanges.submit();
        extentTest.info("new password dogrulandi");


        //Click on "save change"button
        ReusableMethods.bekle(5);
        alloverCommercePage.saveChanges.submit();
        extentTest.info("Degisiklikler kaydedildi");

        //Verify message of "Account details changed successfully"
        Assert.assertTrue(alloverCommercePage.messageVerify.isDisplayed());
        extentTest.info("Basarili giris mesaji göründü");




        extentTest.pass("Checked");
        extentReports.flush();

        Driver.getDriver().quit();



    }
}
