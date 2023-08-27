package tests.US010;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC_01 extends ExtentReport {



/*
user story 10 Password seviyeleri görülebilmeli (Vendor Kaydı için)

1-too short
2-weak
3-good
4-strong
 */

    @Test
    public void test01() {

        extentTest = extentReports.createTest("Fatma", "Allover_Commerce Test Edilebilmeli");

        //Sayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));

        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();

        extentTest.info("AlloverCommerce sayfasina gidildi");


        //Register'a tikla

        alloverCommercePage.registerFatma.click();

        ReusableMethods.bekle(3);

        extentTest.info("Register'a tiklandi");

        // Become a vendor'a tikla

        alloverCommercePage.becomeVendorFatma.click();

        extentTest.info("Become a vendor'a tiklandi");

        // Email yaz

        alloverCommercePage.registerEmailFatma.sendKeys("tomerfaruk045@gmail.com");

        //passwor'e 6 karakterden kisa sayi gir

        alloverCommercePage.registerPasswordFatma.sendKeys("19300");

        extentTest.info("Password'e 6 karakterden kisa sayi girildi");

        ReusableMethods.bekle(3);

        ReusableMethods.scroll(alloverCommercePage.tooShortFatma); //too short yazisina kaydirildi

        Assert.assertTrue(alloverCommercePage.tooShortFatma.isDisplayed()); //too short'ün göründügü test edildi

        extentTest.pass("'Too short' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        // password'e 6 karakterden kisa harf gir

        alloverCommercePage.registerPasswordFatma.clear(); // önceki password sil

        alloverCommercePage.registerPasswordFatma.sendKeys("abcde");

        extentTest.info("Password'e 6 karakterden kisa harf girildi");

        Assert.assertTrue(alloverCommercePage.tooShortFatma.isDisplayed()); //too short'ün göründügü test edildi

        extentTest.pass("'Too short' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        // password'e 6 karakterden kisa hem sayi hem harf gir

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("193ab");

        extentTest.info("Password'e 6 karakterden kisa hem sayi hem harf girildi");

        Assert.assertTrue(alloverCommercePage.tooShortFatma.isDisplayed()); //too short'ün göründügü test edildi

        extentTest.pass("'Too short' yazisinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        //password'e 5 karakterden uzun sayi gir.

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("193003");

        extentTest.info("Password'e 5 karakterden uzun sayi girildi");

        Assert.assertTrue(alloverCommercePage.weakFatma.isDisplayed()); //weak yazisinin glründügü test edildi

        extentTest.pass("'Weak' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        //password'e 5 karakterden uzun harf gir.

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

       alloverCommercePage.registerPasswordFatma.sendKeys("abcdef");

       extentTest.info("Password'e 5 karakterden uzun harf girildi");

        Assert.assertTrue(alloverCommercePage.weakFatma.isDisplayed()); //weak yazisinin göründügü test edildi

        extentTest.pass("'Weak' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        //password'e 5 karakterden uzun hem harf hem sayi gir.

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("193003f");


        extentTest.info("Password'e 5 karakterden uzun hem harf hem sayi girildi");

        Assert.assertTrue(alloverCommercePage.weakFatma.isDisplayed()); //weak yazisinin göründügü test edildi

        extentTest.pass("'Weak' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        //password'e 7 karakterden uzun hem sayı hem harf gir.

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("19300395fb");

        extentTest.info("Password'e 7 karakterden uzun hem sayi hem harf girildi");

        Assert.assertTrue(alloverCommercePage.goodFatma.isDisplayed()); //good yazisinin göründügü test edildi

        extentTest.pass("'Good' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

        //6 karakterden uzun harf rakam ve sembol gir

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("19300395f+");

        extentTest.info("Password'e 6 karakterden uzun harf rakam ve sembol girildi");

        Assert.assertTrue(alloverCommercePage.goodFatma.isDisplayed()); //good yazisinin göründügü test edildi

        extentTest.pass("'Good' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);

         // 6 karakterden uzun büyük-küçük harf rakam ve sembol gir

        alloverCommercePage.registerPasswordFatma.clear();  // önceki password silindi

        alloverCommercePage.registerPasswordFatma.sendKeys("19300395f+F");

        extentTest.info("Password'e 6 karakterden büyük-kücük harf, rakam ve sembol girildi");

        Assert.assertTrue(alloverCommercePage.strongFatma.isDisplayed()); //strong yazisinin göründügü test edildi

        extentTest.pass("'Strong' seviyesinin görüntülendigi test edildi");

        ReusableMethods.bekle(3);















    }
}
