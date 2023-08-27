package tests.US018;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
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

        Driver.getDriver().findElement(By.xpath("//*[@class='login inline-type']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@class='woocommerce-Input woocommerce-Input--text input-text']")).sendKeys(ConfigReader.getProperty("vendorEmailUs16"), Keys.ENTER, Keys.TAB);

        Driver.getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(ConfigReader.getProperty("vendorPasswordUs16"), Keys.ENTER);

        Driver.getDriver().findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        extentTest.info("Vendor olarak giris yapildi.");

        Driver.getDriver().findElement(By.xpath("//*[@href='https://allovercommerce.com/my-account-2/'][1]")).click();

        Driver.getDriver().findElement(By.xpath("//*[@href='https://allovercommerce.com/store-manager/']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")).click();

        Driver.getDriver().findElement(By.xpath("(//*[@class='text'])[18]")).click();

        Driver.getDriver().findElement(By.xpath("//*[@id='add_new_coupon_dashboard']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@name='title']")).sendKeys(ConfigReader.getProperty("code"));
        extentTest.info("Cod Yazildi");

        Driver.getDriver().findElement(By.xpath("//*[@name='description']")).sendKeys(ConfigReader.getProperty("description"));
        extentTest.info("Description yazildi");

        //Driver.getDriver().findElement(By.xpath("//*[@id='discount_type']")).sendKeys(ConfigReader.getProperty("discountType"));

        Driver.getDriver().findElement(By.xpath("//*[@id='discount_type']")).sendKeys(ConfigReader.getProperty("discountType1"));
        extentTest.info("Fixed Product Discount secildi");

        Driver.getDriver().findElement(By.xpath("//*[@id='coupon_amount']")).sendKeys(ConfigReader.getProperty("couponAmount"));
        extentTest.info("Coupon Amount yazildi ama degeri bir sifir fazla aldi (Bug)");

        Driver.getDriver().findElement(By.xpath("//*[@id='expiry_date']")).sendKeys(ConfigReader.getProperty("expiryDate"),Keys.TAB);
        ReusableMethods.bekle(5);
        extentTest.info("Coupon Exp. Date girildi.");

        Driver.getDriver().findElement(By.xpath("//*[@id='free_shipping']")).click();
        ReusableMethods.bekle(4);

        Driver.getDriver().findElement(By.xpath("//*[@id='show_on_store']")).click();
        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);
        extentTest.info("Allow free shipping ve Show on Store secildi.");

        Driver.getDriver().findElement(By.xpath("//*[@id='wcfm_coupon_manager_submit_button']")).click();
        ReusableMethods.scrollHome();
        ReusableMethods.bekle(2);

        Driver.getDriver().findElement(By.xpath("//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")).click();
        ReusableMethods.bekle(2);

        Driver.getDriver().findElement(By.xpath("(//*[@class='wcfm_dashboard_item_title'])[1]")).click();
        System.out.println("Coupons olusturuldugu goruldu");

        extentTest.info("Coupons olusturuldugu goruldu");

    }
}
