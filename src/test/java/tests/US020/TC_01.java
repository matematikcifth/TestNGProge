package tests.US020;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void testShopAsVendorWithACoupon() {
        extentTest=extentReports.createTest("Team11","Allovercommerce Test Zeynep");
        //Go to page https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("went to allovercommerce.com website");
        //Sign-in as  Vendor
        Allover_Commerce_Page commercePage=new Allover_Commerce_Page();
        commercePage.signInZeynep.click();
        commercePage.emailBoxZeynep.sendKeys(ConfigReader.getProperty("vendorEmail"), Keys.TAB,
                ConfigReader.getProperty("vendorPassword"),Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("signed in as vendor");

        Actions actions=new Actions(Driver.getDriver());
        //Go to search box and search for kids skates
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();
        commercePage.searchBoxZeynep.sendKeys("Kids Skates", Keys.ENTER);
        ReusableMethods.bekle(2);
        commercePage.kidsSkatesZeynep.click();
        ReusableMethods.bekle(2);
        extentTest.info("searched for kids skates in the search box and added the product to the cart ");
        //Click on cart logo and go to checkout
        commercePage.cartLogoZeynep.click();
        commercePage.checkOutZeynep.click();
        extentTest.info("went to checkout page");
        //Verify that the products are added to the cart
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Skates"));
        ReusableMethods.bekle(2);
        extentTest.info("verified that the desire product is in the cart");
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
        extentTest.info("billing address details are filled");
        //The generated coupon should  be entered by clicking the enter your coupon box
        actions.sendKeys(Keys.PAGE_UP).perform();
        commercePage.enterYourCodeZeynep.click();
        commercePage.enterYourCouponHere.sendKeys("neva2");
        extentTest.info("the coupon code is entered in the field");
        commercePage.applyYourCouponButton.click();
        Assert.assertTrue(commercePage.couponCodeIsAppliedSuccessfullyZeynep.isDisplayed());
        extentTest.info("verified that the coupon has been applied successfully");
    }

    @Test
    public void testShopAsVendorWithCouponNegatif() {
        extentTest=extentReports.createTest("Team11","Allovercommerce TestNegative Zeynep");
        //Go to page https://allovercommerce.com
        Driver.getDriver().get(ConfigReader.getProperty("allowerceUrl"));
        ReusableMethods.bekle(2);
        extentTest.info("went to allovercommerce.com website");
        //Sign-in as  Vendor
        Allover_Commerce_Page commercePage=new Allover_Commerce_Page();
        commercePage.signInZeynep.click();
        commercePage.emailBoxZeynep.sendKeys(ConfigReader.getProperty("vendorEmail"), Keys.TAB,
                ConfigReader.getProperty("vendorPassword"),Keys.TAB,Keys.TAB, Keys.TAB, Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("signed in as vendor");
        //Go to search box and search for backpack
        Actions actions=new Actions(Driver.getDriver());
        commercePage.searchBoxZeynep.sendKeys("Comfortable Backpack", Keys.ENTER);
        ReusableMethods.bekle(2);
        commercePage.addBackpackToCart.click();
        ReusableMethods.bekle(2);
        extentTest.info("searched a bag in the search box and added to the cart");
        //Click on cart logo and go to checkout
        commercePage.cartLogoZeynep.click();
        commercePage.checkOutZeynep.click();
        extentTest.info("went to checkout page");
        //Verify that the product is added to the cart
        Assert.assertTrue(commercePage.productsInTheCartZeynep.getText().contains("Backpack"));
        ReusableMethods.bekle(2);
        extentTest.info("verified that the product is visible in the cart");
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
        extentTest.info("billing address details are filled");
        //The generated coupon should  be entered by clicking the enter your coupon box
        actions.sendKeys(Keys.PAGE_UP).perform();
        commercePage.enterYourCodeZeynep.click();
        commercePage.enterYourCouponHere.sendKeys("zeynep123");
        commercePage.applyYourCouponButton.click();
        extentTest.info("coupon code entered in the required field and clicked on apply code");
        Assert.assertTrue(commercePage.couponIsNotApplicableZeynep.isDisplayed());
        extentTest.info("'the coupon is not applicable on the selected product' is visible");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().findElement(By.id("place_order")).submit();
        extentTest.info("place order button is clicked");
        Driver.closeDriver();
        extentTest.info("driver is closed");

    }
}
