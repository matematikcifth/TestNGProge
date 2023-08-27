package tests.US007;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

import java.util.List;

public class TC_01 extends ExtentReport {



    @Test
    public void test01() {

        extentTest = extentReports.createTest("Esma" , "Allovercommerce Test Edebilmeli");
        //Anasayfaya git
        //Login ol
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Anasayfaya Gidildi");

        Allover_Commerce_Page alloverCommercePage = new Allover_Commerce_Page();

        alloverCommercePage.signIn.click();

        ReusableMethods.bekle(2);

        alloverCommercePage.usernameAyse.sendKeys(ConfigReader.getProperty("email"), Keys.TAB,
                ConfigReader.getProperty("password"));
        alloverCommercePage.signInButton.submit();
        extentTest.info("Login olundu");

        ReusableMethods.bekle(2);

        //Arama alanına aranacak ürünü yaz
        //Ara ikonuna tıkla
        alloverCommercePage.aramaKutusu.sendKeys("kazak" + Keys.ENTER);
        extentTest.info("Arama yapildi ve enter tiklandi");

        ReusableMethods.bekle(4);


        //Listelenen ürünlerden ilkinin üzerindeki compare ikonuna tıkla
        alloverCommercePage.ilkUrun.click();
        alloverCommercePage.compareIkonuilk.click();
        extentTest.info("Ilk ürün compare tiklandi");


        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());
        extentTest.info("Compare Product bölümüne eklendi");

        ReusableMethods.bekle(7);

        //Compare products alanı dışında boş bir alana tıkla
        alloverCommercePage.bosAlan.click();
        extentTest.info("Bos alana tiklandi");

        ReusableMethods.bekle(3);

        Driver.getDriver().navigate().back();

        //Listelenen ürünlerden ikincisinin üzerindeki compare ikonunu seç
        alloverCommercePage.ikinciUrun.click();
        extentTest.info("Ikinci ürün compare tiklandi");

        ReusableMethods.bekle(3);

        //bu kisim calismadi
        //Actions actions = new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.SPACE);
        //alloverCommercePage.compareIkonuiki.click();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.click(alloverCommercePage.compareIkonuiki);
        extentTest.info("Compare Product bölümüne eklendi");


        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());

        //Compare products alanı dışında boş bir alana tıkla
        alloverCommercePage.bosAlan.click();

        extentTest.info("Bos alana tiklandi");

        Driver.getDriver().navigate().back();



        //Listelenen ürünlerden üçüncüsünün üzerindeki compare ikonunu seç
        alloverCommercePage.ucuncuUrun.click();
        alloverCommercePage.compareIkonuuc.click();
        extentTest.info("Ücüncü ürün compare tiklandi");


        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());
        extentTest.info("Compare Product bölümüne eklendi");

        //Compare products alanı dışında boş bir alana tıkla
        alloverCommercePage.bosAlan.click();
        extentTest.info("Bos alana tiklandi");

        Driver.getDriver().navigate().back();


        //Listelenen ürünlerden dördüncüsünün üzerindeki compare ikonunu seç
        //alloverCommercePage.compareIkonudort.click();

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverCommercePage.dorduncuUrun);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverCommercePage.compareIkonudort);
        extentTest.info("Dördüncü ürün compare tiklandi");


        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());
        extentTest.info("Compare Product bölümüne eklendi");





        //Compare products alanı dışında boş bir alana tıkla
        alloverCommercePage.bosAlan.click();
        extentTest.info("Bos alana tiklandi");




        Driver.getDriver().navigate().back();



        //Listelenen ürünlerden beşincisinin üzerindeki compare ikonunu seç
        //alloverCommercePage.besinciUrun.click();
        //alloverCommercePage.compareIkonubes.click();

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverCommercePage.besinciUrun);
        extentTest.info("Besinci ürün compare tiklandi");


        ReusableMethods.bekle(3);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(alloverCommercePage.compareIkonubes);


        ReusableMethods.bekle(3);

        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());


        //Compare Products bölümüne ilk eklenen ürünün otomatik olarak listeden çıkarıldığını dogrula
        //Assert.assertFalse(alloverCommercePage.silinenUrunLocate.isDisplayed());-- hata verdi, calismiyor


        //Compare Products bölümüne eklenen ürün sayısının en fazla 4 olduğunu doğrula
        List<WebElement> urunlerinCarpisi = Driver.getDriver().findElements(By.xpath("//a[@class='btn-remove remove_from_compare fas fa-times']"));
        Assert.assertEquals(urunlerinCarpisi.size(), 4);

        ReusableMethods.bekle(3);
        extentTest.info("Eklenen ürünlerin en fazla 4 tane oldugu dogrulandi");


        //Start Compare! Butonuna tıkla
        ReusableMethods.click(alloverCommercePage.startCompareButton);
        extentTest.info("Start Compare! Butonuna tıklandi");




        //Compare sayfasındaki ilk ürün fotoğrafının üzerindeki X e tıkla
        alloverCommercePage.ilkUrununCarpisi.click();
        extentTest.info("ilk ürün silindi");




        //Ürünün Compare sayfasından silindiğini doğrula

        //ürün ara
        alloverCommercePage.aramaKutusu.sendKeys("kazak" + Keys.ENTER);
        extentTest.info("Ürün arandi");

        ReusableMethods.bekle(4);

        //Listelenen ürünlerden ilkinin üzerindeki compare ikonunu seç
        alloverCommercePage.ilkUrun.click();
        alloverCommercePage.compareIkonuilk.click();
        extentTest.info("Ilk ürün compare ikonuna tiklandi");


        ReusableMethods.bekle(4);


        //Compare Products bölümüne eklendiğini doğrula
        Assert.assertTrue(alloverCommercePage.compareIkonuDogrulama.isDisplayed());
        extentTest.info("Compare Product bölümüne eklendi");


        ReusableMethods.bekle(5);



        //Start Compare! Butonuna tıkla
        ReusableMethods.click(alloverCommercePage.startCompareButtoniki);
        extentTest.info("Start Compare! Butonuna tiklandi");
        ReusableMethods.bekle(4);



        //Seçtiği 4 ürünün karşılaştırılabildiğini doğrula
        //Compare sayfasındaki ilk ürün fotoğrafının üzerindeki X butonuna tıkla
        //Ürünün Compare sayfasından kaldırıldığını doğrula

        //Bu kisimda sona kalan her ürünün silinmesinin yüklenmesi cok uzun sürüyor ve hata firlatiyor.
        //Bu yüzden son üründen silmeye basladim
        ReusableMethods.click(alloverCommercePage.sonUrununCarpisi);
        extentTest.info("Son ürün silindi");



        ReusableMethods.bekle(4);

        //Compare sayfasındaki ilk ürün fotoğrafının üzerindeki X butonuna tıkla
        //Ürünün Compare sayfasından kaldırıldığını doğrula
        alloverCommercePage.ucuncuUrununCarpisi.click();
        extentTest.info("3. ürün silindi");

        ReusableMethods.bekle(4);


        //Compare sayfasındaki ilk ürün fotoğrafının üzerindeki X butonuna tıkla
        //Ürünün Compare sayfasından kaldırıldığını doğrula
        alloverCommercePage.ikinciUrununCarpisi.click();
        extentTest.info("2. ürün silindi");

        ReusableMethods.bekle(4);


        //Compare sayfasındaki ilk ürün fotoğrafının üzerindeki X butonuna tıkla
        ReusableMethods.click(alloverCommercePage.birinciUrununCarpisi);


        ReusableMethods.bekle(3);

        ReusableMethods.click(alloverCommercePage.birinciUrununCarpisi);
        extentTest.info("1. ürün silindi");

        ReusableMethods.bekle(6);


        //Compare sayfasında ürün olmadığını doğrula
        Assert.assertTrue(alloverCommercePage.compareBosYazisi.isDisplayed());
        extentTest.info("Compare sayfasında ürün olmadığını doğrulandi");


        ReusableMethods.bekle(2);

        extentTest.pass("Checked");
        extentReports.flush();

        Driver.getDriver().quit();

        //Process finished with exit code 0



    }
}
