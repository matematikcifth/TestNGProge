package tests.US016;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
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



public class TC_01 extends ExtentReport {

    @Test
    public void test01() {
        System.out.println("serkan");


    }

    @Test
    public void test02() {
        extentTest = extentReports.createTest("Serkan" , "Allovercommerce Test Edilebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        extentTest.info("Allovercommerce Sayfasina gidildi");

        Driver.getDriver().findElement(By.xpath("//*[@class='login inline-type']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@class='woocommerce-Input woocommerce-Input--text input-text']")).sendKeys(ConfigReader.getProperty("vendorEmailUs16"), Keys.ENTER, Keys.TAB);

        Driver.getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(ConfigReader.getProperty("vendorPasswordUs16"), Keys.ENTER);

        Driver.getDriver().findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);

        Driver.getDriver().findElement(By.xpath("//*[@href='https://allovercommerce.com/my-account-2/'][1]")).click();

        Driver.getDriver().findElement(By.xpath("//*[@href='https://allovercommerce.com/store-manager/']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")).click();
        ReusableMethods.bekle(2);

        Driver.getDriver().findElement(By.xpath("(//*[@class='text'])[18]")).click();//Simple Produckt default olarak geldi.
        ReusableMethods.bekle(2);
        extentTest.info("Simple Produckt default olarak geldi");

        Driver.getDriver().findElement(By.xpath("//*[@id='is_virtual']")).click();
        extentTest.info("Virtual secildi");

        Driver.getDriver().findElement(By.xpath("//*[@id='is_downloadable']")).click();
        extentTest.info("Downloadable secildi");

        Driver.getDriver().findElement(By.xpath("//*[@id='pro_title']")).sendKeys(ConfigReader.getProperty("productTitleUs16"));
        extentTest.info("Product Title yazildi");

        Driver.getDriver().findElement(By.xpath("//*[@id='regular_price']")).sendKeys(ConfigReader.getProperty("productPriceUs16"));
        extentTest.info("Product Price yazildi");

        Driver.getDriver().findElement(By.xpath("//*[@id='sale_price']")).sendKeys(ConfigReader.getProperty("salePriceUs16"));
        ReusableMethods.bekle(5);
        extentTest.info("Sale Price yazildi");

        Allover_Commerce_Page page = new Allover_Commerce_Page();
        WebElement catogry = page.categoryTitleUs16;
        ReusableMethods.scroll(catogry);
        WebElement click = page.categoryAccessories;
        ReusableMethods.click(click);
        extentTest.info("Catagori secildi");

        ReusableMethods.click(Driver.getDriver().findElement(By.xpath("(//*[@type='submit'])[2]")));
        extentTest.info("(Urun)Product eklenemedi ve hata raporu alindi. ");

        WebElement rapor = page.hataRaporu;
        Assert.assertTrue(rapor.isDisplayed());
        extentTest.info(" Hata raporu goruldu. ");

        extentTest.info("Urun Product kisminda görülemedi");
    }
}

