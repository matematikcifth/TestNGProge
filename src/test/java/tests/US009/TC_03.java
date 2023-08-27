package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import pages.FakemailPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_03 extends ExtentReport {

    FakemailPages fakemail_pages = new FakemailPages();
    Allover_Commerce_Page allover = new Allover_Commerce_Page();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Sayfaya Gidildi");

        //   https://www.fakemail.net/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("fakemail_url"));

        //Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));



        //Kullanici sag üst kösedeki register yazisina tiklar
        allover.registerfth.click();
        extentTest.info("Register yazisina tiklandi");

        //Kullanici acilan pencerenin en altinda  "Became  Vendor "yazisina tiklar
        ReusableMethods.bekle(2);
        allover.Became_vendor.click();
        extentTest.info("Became  Vendor yazisina tiklandi");

        //Kullanici Vendor Registration sayfasina gider
        Assert.assertTrue(allover.Vendor_registratio_yazisi.isDisplayed());
        System.out.println("Tc 1 basari ile noktalandi ");

        extentTest.info("Registration Sayfasina gidildi");

        //Kullanici e mail kutucuguna tiklar
        Assert.assertTrue(allover.email_kutucugu.isEnabled());
        extentTest.info("E-mail kutucuguna tiklandi");

        // Kullanici e mail kutucuguna valid bir deger girer            //conley.dyllan@fixedfor.com
        allover.email_kutucugu.sendKeys("conley.dyllan@fixedfor.com");
        extentTest.info("E-mail kutucuguna yazisina tiklandi");

        // Kullanici verifcation text kutusuna tiklar
        allover.verification_code_kutusu.click();

        extentTest.info("Verifcation text kutusuna tiklandi");


        // Kullanici Verification code kutucuguna "0000000" girer

        allover.verification_code_kutusu.sendKeys("000000");
        extentTest.info("Verifcation text kutusuna kod girildi");

        // Kullanci password kutucuguna tiklar
        ReusableMethods.click(allover.password_kutucugu);
        // PASSWORD KUTUCUGU JAVA SCRIPT KODLARI ILE YAZILMIS : BUNDAN DOLAYI REASUBALE METODDAKI CLICK ILE  CALISTI

        extentTest.info("Password kutusuna tiklandi");




        // Kullanici buyuk harf kucuk haf rakam iceren  invalid bir sifre girer

        allover.password_kutucugu.sendKeys("AhmetABI.123");
        extentTest.info("Invalid sifre girildi");

        //  Kullanci confirm password alanina tiklar
        ReusableMethods.click(allover.confirm_password_kutucugu);

        extentTest.info("Confirm Password kutucuguna tiklandi");

        // Kullanici confirm password alanina sifreyi tekrar girer
        allover.confirm_password_kutucugu.sendKeys("AhmetABI.123");

        extentTest.info("Confirm password alanina sifreyi tekrar girildi");

        // Kullanici  register butonuna tiklar
        ReusableMethods.click(allover.register_butonu);
        extentTest.info(" Register butonuna tiklartiklandi");

        // uyari yazisi icin gerekli süre beklenir
        ReusableMethods.visibleWait(allover.bu_mail_adresi_kayitli_yazisi,10);
        extentTest.info("Gerkli sure kadar beklendi");

        //Kullanici ekranda "This Email already exists. Please login to the site and apply as vendor." hata mesajini görür
        Assert.assertTrue(allover.bu_mail_adresi_kayitli_yazisi.getText().contains("This Email already exists"));
        extentTest.info("Hata mesaji goruldu");



    }

}
