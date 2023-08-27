package tests.US017;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Allover_Commerce_Page;
import utilities.*;

public class TC_01 extends ExtentReport{
    @Test
    public void testShopAsVendor() {
        extentTest=extentReports.createTest("Team11","Allovercommerce Test Zeynep");
        //Go to page https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("went to allovercomerce website ");
        //Sign-in as  Vendor
        Allover_Commerce_Page commercePage=new Allover_Commerce_Page();
        commercePage.signInZeynep.click();
        commercePage.emailBoxZeynep.sendKeys(ConfigReader.getProperty("fakeEmailZeynep"), Keys.TAB,
                ConfigReader.getProperty("fakePasswordZeynep"),Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("signed is as vendor");
        //Scroll down the page till you see the products
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        extentTest.info("scrolled down on the page to browse products");
        //Select a products and add to the cart
        commercePage.product1Zeynep.click();
        ReusableMethods.bekle(2);
        //Go to search box and search for backpack
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        commercePage.searchBoxZeynep.sendKeys("backpack", Keys.ENTER);
        ReusableMethods.bekle(2);
        commercePage.addBackpackToCart.click();
        ReusableMethods.bekle(2);
        extentTest.info("chess and a backpack added to the cart");
        //Click on cart logo and go to checkout
        commercePage.cartLogoZeynep.click();
        commercePage.checkOutZeynep.click();
        extentTest.info("checked out to purchase the products in the cart");
        //Verify that the products are added to the cart
        //Assert.assertTrue(commercePage.productsInTheCartZeynep.isDisplayed());//bu da belki olabilir, cunku tbody sadece urun ekledigimizde ortaya cikiyor, display olmussa icinde urun var demektir
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Chess"));
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Comfortable Backpack"));
        ReusableMethods.bekle(2);
        extentTest.info("verified that the products in the cart are visible");
        //Go to checkout page and fill in the billing details
        commercePage.billingNameZeynep.sendKeys("Zeynep");
        commercePage.billingLastNameZeynep.sendKeys("Altun");
        ReusableMethods.bekle(2);
        WebElement countryDropDown=commercePage.countryDDM;
        Select select=new Select(countryDropDown);
        select.selectByVisibleText("United Kingdom (UK)");
        ReusableMethods.bekle(2);
        commercePage.billingAddressNo.sendKeys("19");
        commercePage.billingCity.sendKeys("Rochester");
        commercePage.billingCounty.sendKeys("Kent");
        commercePage.billingPostCode.sendKeys("ME22DQ");
        commercePage.billingPhone.sendKeys("+447380399011");
        extentTest.info("information on the billing address is filled");
        //Total amount should be visible
        Assert.assertTrue(commercePage.totalAmountZeynep.isDisplayed());
        extentTest.info("checked if total amount to be paid was visible");
        //Wire transfer/EFT veya Pay at the door options should be selectable.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        commercePage.EFTRadioButton.click(); //click yapmaya gerek yok otomatik olarak developerlar bu secenegi tiklamis hata veriyor, zaten secili oldugu icin
        Assert.assertTrue(commercePage.EFTRadioButton.isSelected());
        ReusableMethods.bekle(2);
        commercePage.payAtDoorRadioButton.click();
        Assert.assertTrue(commercePage.payAtDoorRadioButton.isSelected());
        extentTest.info("checked if the payment methods were visible and clickable");
        //By clicking on Place Order, the user should be able to see that the shopping has been completed.
        commercePage.placeOrderZeynep.click();
        ReusableMethods.bekle(15);
        extentTest.info("order has been placed");
        String siparisAlindiYazisi=commercePage.thankYouOrderHasBeenReceivedYazisi.getText();
        String expected="Thank you. Your order has been received.";
        Assert.assertEquals(siparisAlindiYazisi,expected);
        extentTest.info("checked if the 'order has been received' sentence was visible");
        //User should be able to see the details of his/her purchase by clicking My Account -Orders.
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        ReusableMethods.click(commercePage.myAccountmyOrdersZeynep);
        commercePage.orderViewZeynep.click();
        Assert.assertTrue(commercePage.orderDetailsYazisiZeynep.isDisplayed());
        extentTest.info("clicked on myAccount/myOrder to check whether the order details are visible");

    }

    @Test
    public void test02() {
        //Go to page https://allovercommerce.com
        extentTest=extentReports.createTest("Team11","Allovercommerce TestNegative Zeynep");
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("went allovercomerce website ");
        //Sign-in as  Vendor
        Allover_Commerce_Page commercePage=new Allover_Commerce_Page();
        commercePage.signInZeynep.click();
        commercePage.emailBoxZeynep.sendKeys(ConfigReader.getProperty("vendorEmail"), Keys.TAB,
                ConfigReader.getProperty("vendorPassword"),Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("signed is as vendor");
        //Scroll down the page till you see the products
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        extentTest.info("scrolled down on the page to browse products");
        //Select a products and add to the cart
        commercePage.product1Zeynep.click();
        ReusableMethods.bekle(2);
        //Go to search box and search for backpack
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        commercePage.searchBoxZeynep.sendKeys("backpack", Keys.ENTER);
        ReusableMethods.bekle(2);
        commercePage.addBackpackToCart.click();
        ReusableMethods.bekle(2);
        extentTest.info("chess and a backpack added to the cart");
        //Click on cart logo and go to checkout
        commercePage.cartLogoZeynep.click();
        commercePage.checkOutZeynep.click();
        extentTest.info("checked out to purchase the products in the cart");
        //Verify that the products are added to the cart
        //Assert.assertTrue(commercePage.productsInTheCartZeynep.isDisplayed());//bu da belki olabilir, cunku tbody sadece urun ekledigimizde ortaya cikiyor, display olmussa icinde urun var demektir
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Chess"));
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Comfortable Backpack"));
        ReusableMethods.bekle(2);
        extentTest.info("verified that the products in the cart are visible");
        //Go to checkout page and fill in the billing details
        commercePage.billingNameZeynep.sendKeys("Zeynep");
        commercePage.billingLastNameZeynep.sendKeys("Altun");
        ReusableMethods.bekle(2);
        WebElement countryDropDown=commercePage.countryDDM;
        Select select=new Select(countryDropDown);
        select.selectByVisibleText("United Kingdom (UK)");
        ReusableMethods.bekle(2);
        commercePage.billingAddressNo.sendKeys("19");
        commercePage.billingCity.sendKeys("Rochester");
        commercePage.billingCounty.sendKeys("Kent");
        commercePage.billingPostCode.sendKeys("ME22DQ");
        commercePage.billingPhone.sendKeys("+447380399011");
        extentTest.info("billing information is filled by leaving one mandatory field unfilled");
        //Total amount should be visible
        Assert.assertTrue(commercePage.totalAmountZeynep.isDisplayed());
        extentTest.info("checked if total amount to be paid was visible");
        //Wire transfer/EFT veya Pay at the door options should be selectable.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.bekle(2);
        commercePage.payAtDoorRadioButton.click();
        extentTest.info("pay at the door option has been chosen");
        //By clicking on Place Order, the user should be able to see that the shopping has been completed.
        commercePage.placeOrderZeynep.click();
        ReusableMethods.bekle(1);
        Assert.assertTrue(commercePage.warningMessageZeynep.isDisplayed());
        extentTest.info("Warning message has been received as mandatory fields in the billing address was not filled");
        Driver.closeDriver();
        extentTest.info("driver is closed");

    }
}
