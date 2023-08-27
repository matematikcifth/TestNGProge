package tests.US009;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import pages.FakemailPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_02 extends ExtentReport {
    @Test
    public void test01() {

        FakemailPages fakemail_pages = new FakemailPages();
        Allover_Commerce_Page allover = new Allover_Commerce_Page();

        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

        extentTest.info("Sayfaya Gidildi");
        //   https://www.fakemail.net/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("fakemail_url"));

        ReusableMethods.bekle(3);
        fakemail_pages.consentf.click();
        extentTest.info(" https://www.fakemail.net/  Sayfaya Gidildi");

        //acilan sayfanin windowhandl degeri alinir
        String fake_mail_sayfasinin_hash_kodu=Driver.getDriver().getWindowHandle();
        System.out.println(fake_mail_sayfasinin_hash_kodu);

        extentTest.info("acilan sayfanin windowhandl degeri alindi ");

        //e mail kutucugundaki mail adresi String maile atanir

        String email = fakemail_pages.email_kutucugu.getText();
        System.out.println(email);

        extentTest.info("e mail kutucugundaki mail adresi String maile atan");


        // yeni bir tab acilir

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        extentTest.info(" yeni bir tab acildi");


        //Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

        extentTest.info("Ana sayfaya gidildi ");

        //acilan sayfanin hash kodu alinir
        String allovercommerce_sayfasinin_hash_kodu =Driver.getDriver().getWindowHandle();

        extentTest.info("Acilan sayfanin hash kodu alindi");

        //Kullanici sag üst kösedeki register yazisina tiklar
        allover.registerfth.click();
        extentTest.info("Register yazisina tiklandi");

        //Kullanici acilan pencerenin en altinda  "Became  Vendor "yazisina tiklar
        ReusableMethods.bekle(2);
        allover.Became_vendor.click();

        ReusableMethods.bekle(2);
        extentTest.info("Became  Vendor yazisina tiklandi");


        //Kullanici Vendor Registration sayfasina gider
        Assert.assertTrue(allover.Vendor_registratio_yazisi.isDisplayed());
        //System.out.println("Tc 1 basari ile noktalandi ");

        ReusableMethods.bekle(2);

        extentTest.info("Registration Sayfasina gidildi");

        //Kullanici e mail kutucuguna tiklar
        Assert.assertTrue(allover.email_kutucugu.isEnabled());

        extentTest.info("E-mail kutucuguna  tiklandi");

        // Kullanici e mail kutucuguna valid bir deger girer
        allover.email_kutucugu.sendKeys(email);

        extentTest.info("E-mail kutucuguna valid bir deger girildi");

        // Kullanici verifcation text kutusuna tiklar
        allover.verification_code_kutusu.click();

        ReusableMethods.bekle(4);
        extentTest.info("Verifcation text kutusuna tiklandi");


        // "Kullanici mail adresine gelen kodu Verification code kutucuguna girer "


        // kodu almak icin tekrar fakemail sitesine gidilir
        Driver.getDriver().switchTo().window(fake_mail_sayfasinin_hash_kodu);
        ReusableMethods.bekle(7);
        extentTest.info(" kodu almak icin tekrar fakemail sitesine gidildi");

        //  mailimize gelen sifre mesajina tiklanir
        fakemail_pages.gelen_sifre_mektubu.click();
        extentTest.info(" Maile gelen sifre mesajina tiklandi");


        // gelen mesaj metinin almak icin iframe e gecis yapilir

        Driver.getDriver().switchTo().frame(fakemail_pages.gelen_mesaj_icin_ifame);
        extentTest.info(" Iframe gecis yapildi");


        // acilan mesajdaki sifre alinir
        String dogrulama_kodu=fakemail_pages.gelen_sifre_mesaji.getText();
        System.out.println(dogrulama_kodu);
        System.out.println(dogrulama_kodu.length());

        extentTest.info(" acilan mesajdaki sifre alindi");



        // gelen mesajdaki kod alinir
        String kullanilacak_rakamlar=fakemail_pages.gelen_sifre_mesaji.getText().replaceAll("[^0-9]","");
        System.out.println("*********Hic kolay olmadi**********");
        System.out.println(kullanilacak_rakamlar);
        extentTest.info(" gelen mesajdaki kod alindi");


        // String olan rakamlar integer a cevrilir ve kullanima hazir hale getirilir
        int kullanilacak_rakamlarin_son_hali = Integer.parseInt(kullanilacak_rakamlar);

        extentTest.info("String olan rakamlar integer a cevrildi ve kullanima hazir hale getirildi ");

        // driver parent  frame e alinir
        Driver.getDriver().switchTo().parentFrame();
        extentTest.info(" driver parent  frame e alindi");


        // alisveris sitesine tekrar gecilir
        Driver.getDriver().switchTo().window(allovercommerce_sayfasinin_hash_kodu);
        extentTest.info(" alisveris sitesine tekrar gecildi");


        //Verification kode  alanina   kullanicilack integr kod girilir
        //  allover.verification_code_kutusu.sendKeys(kullanilacak_rakamlarin_son_hali);

        //Verification kode String rakamlar olarak gönderilir
        allover.verification_code_kutusu.sendKeys(kullanilacak_rakamlar);
        extentTest.info("Verification kode String rakamlar olarak gönderildi");

        // Kullanci password kutucuguna tiklar
        ReusableMethods.click(allover.password_kutucugu);
        extentTest.info("Password kutucuguna tiklandi");



        //Kullanici  buyuk harf, rakam ,ozel karakter iceren invalid sifre girer
        allover.password_kutucugu.sendKeys("Ah-m;E?*~t&(a]");

        extentTest.info("Invalid sifre girildi");


        //  Kullanci confirm password alanina tiklar
        ReusableMethods.click(allover.confirm_password_kutucugu);

        extentTest.info("Confirm Password kutucuguna tiklandi");



        // Kullanici confirm password alanina sifreyi tekrar girer
        allover.confirm_password_kutucugu.sendKeys("Ah-m;E?*~t&(a]");

        extentTest.info("Confirm password alanina sifreyi tekrar girildi");




        // Kullanici  register butonuna tiklar
        ReusableMethods.click(allover.register_butonu);
        ReusableMethods.bekle(3);
        extentTest.info(" Register butonuna tiklartiklandi");


        //"Kullanici siteye yonlendirilir ve   "Welcome to Allover Commerce!"  yazisini görür
        Assert.assertTrue(allover.hosgeldiniz_yazisi.isDisplayed());

        extentTest.info(" \"Welcome to Allover Commerce!\"  yazisini görüldu");

    }
}
