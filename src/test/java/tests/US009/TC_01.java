package tests.US009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_01 extends ExtentReport {

    @Test
    public void test01() {
        Allover_Commerce_Page allover = new Allover_Commerce_Page();
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");

        //    Kullanici ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Sayfaya Gidildi");

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

        ReusableMethods.bekle(2);

        extentTest.info("Registration Sayfasina gidildi");


        //Kullanici e mail kutucuguna tiklar
        Assert.assertTrue(allover.email_kutucugu.isEnabled());

        extentTest.info("E-mail kutucuguna yazisina tiklandi");

        // Kullanici e mail kutucuguna valid bir deger girer
        allover.email_kutucugu.sendKeys("conley.dyllan@fixedfor.com");//148578 kod
        ReusableMethods.bekle(2);
        extentTest.info("E-mail kutucuguna valid bir deger girildi");

        // Kullanici verifcation text kutusuna tiklar
        allover.verification_code_kutusu.click();

        ReusableMethods.bekle(10);

        extentTest.info("verifcation text kutusuna tiklandi");
        Assert.assertTrue(allover.kod_gonderildi_yazisi.getText().contains("Verification code sent to your email: conley.dyllan@fixedfor.com."));

        extentTest.info("Verification code sent to your email: yazisi goruldu");




    }
}
