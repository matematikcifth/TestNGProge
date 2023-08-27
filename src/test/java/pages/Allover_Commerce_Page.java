package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Allover_Commerce_Page {


    public Allover_Commerce_Page(){
    PageFactory.initElements(Driver.getDriver(), this);
}
//12-200 ayse (guncelleme yapildi)

    @FindBy(xpath = "//span[.='Register']")
    public WebElement register;

    @FindBy(id = "reg_username")
    public WebElement usernameAyse;

    @FindBy(id = "reg_email")
    public WebElement emailAyse;

    @FindBy(id = "reg_password")
    public WebElement passwordAyse;

    @FindBy(id = "register-policy")
    public WebElement policy;

    @FindBy(name = "register")
    public WebElement signUpButton;

    @FindBy(xpath = "//*[@class='account']")
    public WebElement signOutButton;

    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement errorMessage;

    @FindBy(className = "showlogin")
    public WebElement pleaseLogin;





























































































































































//esen bey 200-400
@FindBy(xpath = "//*[text()='Sign In']") public WebElement singIn;
    @FindBy(xpath = "//*[@id='username']") public WebElement userName;
    @FindBy(xpath = "//*[text()='Sign In']") public WebElement password;
    @FindBy(xpath = "//*[@id='password']")public WebElement logIn;
    @FindBy(xpath = "//*[@id='menu-item-1079']")public WebElement myAccountButton;
    @FindBy(xpath = "(//button[@type='submit'])[2]") public WebElement billingSignInButton;
    @FindBy(xpath = "//a[text()='Addresses']")public WebElement addressesButton;
    @FindBy(xpath = "(//h3)[1]") public WebElement billingAddressWriting;
    @FindBy(xpath="//a[text()='Add']") public WebElement billingAddButton;
    @FindBy(xpath="//input[@id='billing_first_name']") public WebElement billingFirstNameBox;
    @FindBy(xpath="//input[@id='billing_last_name']")public WebElement billingLastNameBox;
    @FindBy(xpath= "(//select)[1]") public WebElement billingCountrySelect;
    @FindBy(xpath="//*[@id='billing_address_1']") public WebElement billingStreetBox;
    @FindBy(xpath="(//input[@type='text'])[5]") public WebElement billingApartmentBox;
    @FindBy(xpath ="//*[@name='billing_city']") public WebElement billingCityTownBox;
    @FindBy(xpath= "(//select)[2]") public WebElement billingStateSelect;
    @FindBy(xpath = "//*[@name='billing_postcode']") public WebElement billingPostCodeBox;
    @FindBy(xpath= "//*[@id='billing_phone']") public WebElement billingPhoneBox;
    @FindBy(xpath= "//*[@id='billing_email']")  public WebElement billingEmailBox;
    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]") public WebElement editBillingAddress;
    @FindBy(xpath = "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]") public WebElement editShippingAddress;
    @FindBy(xpath= "//button[@value='Save address']") public WebElement billingSubmit;
    @FindBy(xpath= "//*[text()='Address changed successfully.']") public WebElement billingAllert;
    @FindBy(xpath = "//*[@class='woocommerce-error']") public WebElement billingPhoneAlertTC03;
    @FindBy(xpath = "//*[@data-id='billing_first_name']") public WebElement billingFirstNameAlert;
    @FindBy(xpath = "//*[@data-id='billing_last_name']") public WebElement billingLastNameAlert;
    @FindBy(xpath = "//*[@data-id='billing_address_1']") public WebElement billingStreetAdresAlert;
    @FindBy(xpath = "//*[@data-id='billing_city']") public WebElement billingTownCityAlert;
    @FindBy(xpath = "//*[@data-id='billing_phone']") public WebElement billingPhoneNumberAlert;
    @FindBy(xpath = "//*[@data-id='billing_postcode']") public WebElement billingPostCodeAlert;
    @FindBy(xpath = "//*[@data-id='billing_email']") public WebElement billingEmailBoxAlert;
    @FindBy(xpath= "(//a[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")public WebElement shippingAddButton;
    @FindBy(xpath = "//*[@id='shipping_address_1']")  public WebElement shippingStreetAddressBox;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")public WebElement shippingAlert;
    @FindBy(xpath= "(//*[@type='text'])[1]") public WebElement shippingFirstName;
    @FindBy(xpath= "(//*[@type='text'])[2]")public WebElement shippingLastName;
    @FindBy(xpath= "(//*[@type='text'])[4]")public WebElement shippingStreetName;
    @FindBy(xpath= "(//*[@type='text'])[6]") public WebElement shippingTownName;
    @FindBy(xpath= "(//*[@type='text'])[7]") public WebElement shippingZipCode;
    @FindBy(xpath= "(//select)[1]")public WebElement shippingCountrySelect;
    @FindBy(xpath= "(//select)[2]") public WebElement shippingStateSelect;
    @FindBy(xpath= "//*[@name='save_address']") public WebElement shippingSubmit;
    @FindBy(xpath = "//*[text()='First name is a required field.']") public WebElement shippingFirstNameAllert;
    @FindBy(xpath = "//*[text()='Last name is a required field.']") public WebElement shippingLastNameAllert;
    @FindBy(xpath = "//*[text()='Street address is a required field.']") public WebElement shippingStreetAdressAllert;
    @FindBy(xpath = "//*[text()='Postcode is a required field.']") public WebElement shippingPostcodeAllert;
    @FindBy(xpath = "//*[text()='Suburb is a required field.']")public WebElement shippingSuburbAllert;
























































































































































//esma 400 - 600

    //US_5
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButton;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement username;

    @FindBy(xpath = "//p[text()='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement welcomeAllover;

    @FindBy(xpath = "//h3[text()='MY ACCOUNT']")
    public WebElement accountYazisi;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement accountbutton;

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement accounttaOldugunuDogrula;

    @FindBy(xpath = "//a[text()='Account details']")
    public WebElement accountDetailsButton;

    @FindBy(xpath = "//h4[text()='Account Details']")
    public WebElement accountDetailsDogrula;

    @FindBy(xpath = "//input[@name='account_first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='account_last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='account_display_name']")
    public WebElement displayName;

    @FindBy(xpath = "//iframe[@id='user_description_ifr']")
    public WebElement biographyBox;

    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement biographyBoxYazilacakYer;

    @FindBy(xpath = "//legend[text()='Password change']")
    public WebElement PasswordChangeYazisi;

    @FindBy(xpath = "//input[@id='password_current']")
    public WebElement currentPassword;

    @FindBy(xpath = "//button[@value='Save changes']")
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    public WebElement messageVerify ;



    //US_7
    @FindBy(xpath = "(//input[@type='search'])[1]")
    public WebElement aramaKutusu ;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/kahverengi-kadin-kazak/'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement compareIkonuilk;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/balikci-yaka-duz-uzun-kollu-kadin-triko-kazak/'])[2]")
    public WebElement ikinciUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement compareIkonuiki;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/urun/kazak/'])[2]")
    public WebElement ucuncuUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement compareIkonuuc;



    @FindBy(xpath = "//img[@src='https://allovercommerce.com/wp-content/uploads/2022/10/2022-10-14_19-47-18-300x300.png']")
    public WebElement dorduncuUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement compareIkonudort;



    @FindBy(xpath = "//img[@src='https://allovercommerce.com/wp-content/uploads/2022/10/2022-10-14_19-46-46-300x300.png']")
    public WebElement besinciUrun;

    @FindBy(xpath = "(//a[@class='compare btn-product-icon'])[1]")
    public WebElement compareIkonubes;

    @FindBy(xpath = "//div[@class='compare-popup-overlay']")
    public WebElement bosAlan;


    @FindBy(xpath = "(//a[@title='Compare'])[1]")
    public WebElement silinenUrunLocate;


    @FindBy(xpath = "//h3[text()='Compare Products']")
    public WebElement compareIkonuDogrulama ;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/compare-2/'])[2]")
    public WebElement startCompareButton;

    @FindBy(xpath = "//a[text()='Start Compare !']")
    public WebElement startCompareButtoniki;


    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[1]")
    public WebElement ilkUrununCarpisi;

    @FindBy(xpath = "//h2[text()='No products added to the compare']")
    public WebElement compareBosYazisi;

    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[4]")
    public WebElement sonUrununCarpisi;

    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[3]")
    public WebElement ucuncuUrununCarpisi;

    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[2]")
    public WebElement ikinciUrununCarpisi;

    @FindBy(xpath = "(//i[@class='w-icon-times-solid'])[1]")
    public WebElement birinciUrununCarpisi;




































































    //omer 600- 800
@FindBy(xpath = "//*[text()='Sign In']")
public WebElement signInClick;


    @FindBy(xpath = "(//*[@type='text'])[1]")
    public WebElement vendorEmail;

    @FindBy(xpath = "(//*[@type='password'])[1]")
    public WebElement vendorPassword;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;

    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement myAccountIcon;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='text'])[4]")
    public WebElement product;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNew;

    @FindBy(xpath = "//*[@id='product_type']")
    public WebElement productType;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement imgClick;

    @FindBy(xpath = "//*[text()='Select Files']")
    public WebElement selectFileNew;

 //   @FindBy(xpath = "(//*[@id='menu-item-browse'])[2]")
 //  public WebElement mediaLibrary;

  //  @FindBy(xpath = "//*[@class='attachment-preview js--select-attachment type-image subtype-jpeg portrait']")
  //  public WebElement selectFoto;

    @FindBy(xpath = "//*[text()='Select']")
    public WebElement selectFotoButton;

  //  @FindBy(xpath = "//input[@id='file-upload']")
  //  public WebElement updateImg;

    @FindBy(xpath = "//span[@class='media-modal-icon']")
    public WebElement modalIcon;

    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement prductTittle;


    @FindBy(xpath = "//*[@id='excerpt_ifr']")
    public WebElement iframe;


    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement shortDescription;


    @FindBy(xpath = "//*[@id='description_ifr']")
    public WebElement iframe1;


    @FindBy(xpath = "//body[@id='tinymce']")
    public WebElement description;


    @FindBy(xpath = "(//*[@type='checkbox'])[3]")
    public WebElement categories;

    @FindBy(xpath = "//*[text()='+Add new category']")
    public WebElement addNewCategory;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_new_tax_ele wcfm_full_ele'])[1]")
    public WebElement categoryName;

    @FindBy(xpath = "(//*[@class='wcfm-select wcfm_new_parent_taxt_ele wcfm_full_ele'])[1]")
    public WebElement parentddm;

    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addCategory;

    @FindBy(xpath = "(//*[@value='298'])[1]")
    public WebElement productBrands;

    @FindBy(xpath = "(//*[@class='description wcfm_full_ele wcfm_side_add_new_category wcfm_add_new_category wcfm_add_new_taxonomy'])[2]")
    public WebElement addNewProduct;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_new_tax_ele wcfm_full_ele'])[2]")
    public WebElement productName;

    @FindBy(xpath = "(//*[@class='wcfm-select wcfm_new_parent_taxt_ele wcfm_full_ele'])[2]")
    public WebElement productddm;

    @FindBy(xpath = "(//*[@class='button wcfm_add_category_bt wcfm_add_taxonomy_bt'])[2]")
    public WebElement addProduct;

    @FindBy(xpath = "//*[@class='wcfm-tabWrap']")
    public WebElement scroollToPage;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_inventory_head']")
    public WebElement inventory;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_shipping_head']")
    public WebElement shipping;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_attribute_head']")
    public WebElement attribute;

    @FindBy(xpath = "//*[@id='sku']")
    public WebElement sku;

    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement backordersddm;

    @FindBy(xpath = "//*[@id='ReusableMethods.bekle(1);']")
    public WebElement clickButtonId;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")
    public WebElement shippingClick;

    @FindBy(xpath = "//*[@id='weight']")
    public WebElement weightText;

    @FindBy(xpath = "//*[@id='shipping_class']")
    public WebElement shippinClassClick;

    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement proccessingTimeClick;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_attribute_head']")
    public WebElement attributesClick;

    @FindBy(xpath = "//*[@id='attributes_is_active_1']")
    public WebElement attributeColorClick;

    @FindBy(xpath = "(//*[@placeholder='Search for an attribute ...'])[1]")
    public WebElement colorText;

    @FindBy(xpath = "//*[@class='select2-selection__choice']")
    public WebElement colorChoice;

    @FindBy(xpath = "(//*[text()='APPLE1'])[2]")
    public WebElement colorChoice1;

    @FindBy(xpath = "(//*[text()='Add New'])[2]")
    public WebElement addNew2;

    @FindBy(xpath = "(//*[text()='Select none'])[1]")
    public WebElement selectNone1;

    @FindBy(xpath = "//*[@id='attributes_is_active_2']")
    public WebElement clickSize;

    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[3]")
    public WebElement colorSizeText;

    @FindBy(xpath = "(//*[text()='123-123'])[2]")
    public WebElement colorChoice3;

    @FindBy(xpath = "(//*[text()='Add New'])[3]")
    public WebElement addNew3;

    @FindBy(xpath = "(//*[text()='Select none'])[2]")
    public WebElement selectNone2;





























//fatih bey 800 - 1000
  //U9 TC_01
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registerfth;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement Became_vendor;

    @FindBy(xpath = "(//*[text()='Vendor Registration'])[1]")
    public WebElement Vendor_registratio_yazisi;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement email_kutucugu;
    ////*[@name ='wcfm_email_verified_button']
    @FindBy(xpath = "//input[@name='wcfm_email_verified_button']")
    public WebElement re_send_code_kutusu;


    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement verification_code_kutusu;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement kod_gonderildi_yazisi;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement password_kutucugu;


    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirm_password_kutucugu;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement register_butonu;

    @FindBy(xpath = "//h1[text()='Welcome to Allover Commerce!']")
    public WebElement hosgeldiniz_yazisi;

    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")
    public WebElement bu_mail_adresi_kayitli_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement good_yazisi;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement strong_yazisi;

    //div[@class='wcfm-message wcfm-success']
    @FindBy(xpath = "div[@class='wcfm-message wcfm-success']")
    public WebElement registration_successfully_completed_yazisi;

//U9 TC_01+++++++++++++++++bitti
//U8 TC_01 Baslangic

    @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]" ) public WebElement chess_kalp;

    @FindBy(xpath = "//*[@class='w-icon-heart']" ) public WebElement wishlistKalp;
    @FindBy(xpath = "//*[@title='Quick View']" ) public WebElement quickView;
    @FindBy(xpath = "//*[@class='product-meta-inner']" ) public WebElement urunAyrıntı;
    @FindBy(xpath = "//*[@class='wishlist-in-stock']" ) public WebElement inStock;
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-sm add_to_cart alt']" ) public WebElement addToChartf;

    @FindBy(xpath = "(//*[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[11]" ) public WebElement chess;

    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]" ) public WebElement cartfth;

    @FindBy(xpath = "//*[@class='button wc-forward']" ) public WebElement view_cartfth;
//*[@title='Close (Esc)']
@FindBy(xpath = "//*[@title='Close (Esc)']" ) public WebElement quickView_kapat;

////*[@class='page-title-bar']
@FindBy(xpath = "//*[@class='page-title-bar']" ) public WebElement bosluk;

////div[@class='summary entry-summary scrollable'] urun_ayrinti_scroll
@FindBy(xpath = "//div[@class='summary entry-summary scrollable']" ) public WebElement urun_ayrinti_scroll;
// //a[@class='checkout-button button alt wc-forward'] satinal locete
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']" ) public WebElement proceedto_checkout;

// //*[@name='billing_first_name'] billing firstname
@FindBy(xpath = "//*[@name='billing_first_name']" ) public WebElement billigadres_firstname_kutucugu;

// Street adres (//*[@class='input-text '])[4]
@FindBy(xpath = "//*[@name='billing_address_1']" ) public WebElement streetadres_kutusu;

// Province //*[@id ='select2-billing_state-container']
@FindBy(xpath = "(//*[@class='select2-selection__arrow'])[2]" ) public WebElement province_ddm;

// Phone kutusu //*[@id='billing_phone']
@FindBy(xpath = "//*[@id='billing_phone']" ) public WebElement phone_kutusu;
// Place order //*[@id='place_order'] alisveris tamamlama butonu
@FindBy(xpath = "//*[@id='place_order']" ) public WebElement place_order_butonu;

// //p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success'] yazisi
@FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']" ) public WebElement thankyou_yazisi;











































































































//fatma hanim 1000 - 12000
      @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerFatma;
    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeVendorFatma;
    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement registerEmailFatma;
    @FindBy(xpath = "(//*[@type='password'])[1]" )
    public WebElement registerPasswordFatma;
    @FindBy(xpath = "//*[text()='Too short']")
    public WebElement tooShortFatma;
    @FindBy(xpath = "//*[text()='Weak']")
    public WebElement weakFatma;
    @FindBy(xpath = "//*[text()='Good']")
    public WebElement goodFatma;
    @FindBy(xpath = "//*[text()='Strong']")
    public WebElement strongFatma;
    @FindBy(xpath = "//span[text()='Sign In']" )
    public WebElement signInClick1fatma;
    @FindBy(xpath = "(//*[@type='text'])[1]")
    public WebElement vendorEmail1fatma;
    @FindBy(xpath = "(//*[@type='password'])[1]")
    public WebElement vendorPassword1fatma;
    @FindBy(xpath = "(//*[text()='Sign In'])[2]")
    public WebElement signInClick2fatma;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutButtonFatma;
    @FindBy(xpath = "//*[text()='MY ACCOUNT']")
    public WebElement myAccount1fatma;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager1fatma;
    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersFatma;
    @FindBy(xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsFatma;
    @FindBy(xpath = "//*[text()='Addresses']")
    public WebElement addressesFatma;
    @FindBy(xpath = "(//*[text()='Wishlist'])[2]")
    public WebElement wishlistFatma;
    @FindBy(xpath = "(//*[text()='Logout'])[1]")
    public WebElement logoutFatma;
    @FindBy(xpath = "//*[text()='Support Tickets']")
    public WebElement supportTicketsFatma;
    @FindBy(xpath = "//*[text()='Followings']")
    public WebElement followingsFatma;
    @FindBy(xpath = "(//*[text()='Account details'])[1]")
    public WebElement accountDetailsFatma;
    @FindBy(xpath = "(//*[text()='Logout'])[2]")
    public WebElement logout1fatma;
    @FindBy(xpath = "//*[text()='Dashboard']")
    public WebElement dashboardFatma;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccountFatma;
    @FindBy(xpath = "//a [text()='My Account']")
    public WebElement myAccountEnAltFatma;

















































































































































    //m.ali bey 1200 - 1400

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement singin;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement email ;
    @FindBy(xpath = "//*[@id='menu-item-1079']")
    public WebElement myAccount1 ;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[5]/a")
    public WebElement Addresses ;
    @FindBy(xpath = "//*[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement EditBillingAddress;
    @FindBy(xpath = "//input[@id=\"billing_first_name\"]")
    public WebElement addFirstName;
    @FindBy(xpath = "//input[@id=\"billing_last_name\"]")
    public WebElement addLastName;
    @FindBy(xpath = "//*[@id='billing_email']")
    public WebElement verifyemailGetAutomatically;
    @FindBy(xpath = "//*[@id='select2-billing_country-container']")
    public WebElement countryDdm;
    @FindBy(xpath = " //input[@id=\"billing_address_1\"]")
    public WebElement addHouseNumberAndStreetName;
    @FindBy(xpath = " //*[@class='select2-selection__placeholder']")
    public WebElement StateDdm;
    @FindBy(xpath = " //input[@id=\"billing_postcode\"]")
    public WebElement addBillingPostCode;
    @FindBy(xpath = " //*[@id=\"main\"]/div/div/div/div/div/div/div/div[1]/div")
    public WebElement addressChangedSuccessfully;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div")
    public WebElement theErrorMessage;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[2]/div/a")
    public WebElement getEditShippingAddress;
    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement addShippingFirstName;
    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement addShippingLastName;
    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement addShippingStreet;
    @FindBy(xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement shippingAddressChanged;
    @FindBy(xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement firstNameisaRequiredField;


















































































  
  
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 
 //serkan bey 1400 - 1600


    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement vendorSignIn;
    @FindBy(xpath = "//*[@class='woocommerce-Input woocommerce-Input--text input-text']")
    public WebElement userNameOrEmail;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement vendorPasswordUs16;

    @FindBy(xpath ="(//*[@type='submit'])[1]")
    public WebElement SignIn;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/my-account-2/'][1]")
    public WebElement vendorMyAccount;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/store-manager/']")
    public WebElement vendorStoreManager;

    @FindBy(xpath ="//*[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement products;

    //@FindBy(xpath ="(//*[@class='text'])[18]")
   // public WebElement addNewProduct;

    @FindBy(xpath ="//*[@id='product_type']")
    public WebElement productTypeselect;

    /*
    @FindBy(xpath ="//*[@value='simple']")/DropDownMenü
    public WebElement simple;
 */
    @FindBy(xpath ="//*[@id='is_virtual']")
    public WebElement virtual;



    @FindBy(xpath ="//*[@id='is_downloadable']")
    public WebElement downloadable;

    @FindBy(xpath ="//*[@id='pro_title']")
    public WebElement productTitleUs16;

    @FindBy(xpath ="//*[@id='regular_price']")
    public WebElement productPriceUs16;

    @FindBy(xpath ="//*[@id='sale_price']")
    public WebElement salePriceUs16;

    @FindBy(xpath ="//*[@class='wcfm_title wcfm_full_ele']")
    public WebElement categoryTitleUs16;

    @FindBy(xpath ="(//*[@type='checkbox'])[5]")
    public WebElement categoryAccessories;


    @FindBy(xpath ="//div[@id='wcfm_menu']")
    public WebElement hataRaporu;

    @FindBy(xpath ="(//*[@class='page_collapsible_content_holder'])[2]")
    public WebElement downloadableUs16;

    @FindBy(xpath ="//*[@id='downloadable_files_name_0']")
    public WebElement filesNameUs16;
    @FindBy(xpath ="//*[@id='downloadable_files_file_0']")
    public WebElement fileUs16;

    @FindBy(xpath ="(//*[@type='submit'])[2]")
    public WebElement submitProduct;

    @FindBy(xpath ="//*[@class='wcfm_product_title']")
    public WebElement kolye;
//US18
    @FindBy(xpath="//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']")
    public WebElement couponsButon;

    @FindBy(xpath="//*[@id='add_new_coupon_dashboard']")
    public WebElement addNewCoupons;

    @FindBy(xpath="//*[@name='title']")
    public WebElement couponCode;

    @FindBy(xpath="//*[@name='description']")
    public WebElement descriptionTitle;

    @FindBy(xpath="//*[@id='discount_type']")
    public WebElement discountType;

    /*

    @FindBy(xpath ="//*[@value='percent']")/DropDownMenü Discount type
    public WebElement percentTageDiscount;

    @FindBy(xpath ="//*[@value='fixed_product']")
    public WebElement fixedProducktDiscount;

     */


    @FindBy (xpath="//*[@id='coupon_amount']")
    public WebElement couponAmount;

    @FindBy (xpath="//*[@id='expiry_date']")
    public WebElement couponExpiryDate;

    @FindBy (xpath="//*[@id='free_shipping']")
    public WebElement allowFreeShipping;

    @FindBy (xpath="//*[@id='show_on_store']")
    public WebElement showOnStore;

    @FindBy (xpath="//*[@name='submit-data']")
    public WebElement submitCouponData;

    @FindBy (xpath="(//*[@class='wcfm_dashboard_item_title'])[1]")
    public WebElement couponsCode;






















































   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  //yavuz bey 1600 - 1800
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signInButtonyvz;
    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id="password")
    public WebElement userPassword;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInyvz;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement searchBox;

    @FindBy(xpath = "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-id='fbb1175']")
    public WebElement clickToCartButton;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement viewCartButton;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement plusButton;

    @FindBy(xpath = "//button[@title='Minus']")
    public WebElement minusButton;

    @FindBy(xpath = "//button[@value='Update cart']")
    public WebElement updateCartButton;

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//h3[1]")
    public WebElement billingDetails;

    @FindBy(id="billing_first_name")
    public WebElement billingFirsName;

    @FindBy(name="billing_last_name")
    public WebElement billingLastName;

    @FindBy(id="select2-billing_country-container")
    public WebElement countryButton;

    @FindBy(id="select2-billing_country-result-wqpt-GB")
    public WebElement gbButton;

    @FindBy(id="billing_address_1")
    public WebElement streetAddress;

    @FindBy(id="billing_city")
    public WebElement townCityBox;

    @FindBy(id="billing_postcode")
    public WebElement postCodeBox;

   @FindBy(id="billing_phone")
   public WebElement billingPhoneBoxyvz;

   @FindBy(id="billing_email")
    public WebElement billingEmail;

   @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement eftButton;

   @FindBy(id="payment_method_cod")
    public WebElement payAtTheDoorButton;

   @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrderButton;

   @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankYou;

   @FindBy(xpath = "//input[@id='coupon_code']")
    public WebElement couponDiscountBox;

   @FindBy(xpath = "//button[@name='apply_coupon']")
    public WebElement applyCouponButton;

   @FindBy(xpath = "(//h4)[2]")
    public WebElement paymentMethods;

   @FindBy(xpath = "//a[@class='showcoupon']")
    public WebElement showCoupon;












































































































  //zeynep hanim 1800 - 20000
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInZeynep;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailBoxZeynep;

    @FindBy(xpath = "(//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart'])[2]")
    public WebElement product1Zeynep;

    @FindBy(xpath = "(//input[@class='form-control'])[1]")
    public WebElement searchBoxZeynep;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement addBackpackToCart;

    @FindBy(xpath = "(//span[text()='Cart'])[1]")
    public WebElement cartLogoZeynep;

    @FindBy(xpath = "//a[@class='button checkout wc-forward']")
    public WebElement checkOutZeynep;

    @FindBy(xpath = "//table//tbody")
    public WebElement productsInTheCartZeynep;

    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingNameZeynep;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement billingLastNameZeynep;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement billingAddressNo;

    @FindBy(xpath = "//input[@name='billing_city']")
    public WebElement billingCity;

    @FindBy(xpath = "//input[@name='billing_state']")
    public WebElement billingCounty;

    @FindBy(xpath = "//input[@name='billing_postcode']")
    public WebElement billingPostCode;

    @FindBy(xpath = "//input[@name='billing_phone']")
    public WebElement billingPhone;

    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement countryDDM;

    @FindBy(xpath = "//tr[@class='order-total']")
    public WebElement totalAmountZeynep;

    @FindBy(xpath = "//*[@id='payment_method_bacs']")
    public WebElement EFTRadioButton;

    @FindBy(xpath = "//*[@id='payment_method_cod']")
    public WebElement payAtDoorRadioButton;

    @FindBy(xpath = "//button[@class='button alt']")
    public WebElement placeOrderZeynep;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankYouOrderHasBeenReceivedYazisi;

    @FindBy(xpath = "//a[text()='My Orders']")
    public WebElement myAccountmyOrdersZeynep;

    @FindBy(xpath = "//tbody//tr//td[5]//a[1]")
    public WebElement orderViewZeynep;

    @FindBy(xpath = "//h2[text()='Order details']")
    public WebElement orderDetailsYazisiZeynep;

    @FindBy(xpath = "//a[text()='Enter your code']")
    public WebElement enterYourCodeZeynep;

    @FindBy(xpath = "//button[@value='30959']")
    public WebElement kidsSkatesZeynep;

    @FindBy(id = "coupon_code")
    public WebElement enterYourCouponHere;

    @FindBy(xpath = "//button[text()='Apply coupon']")
    public WebElement applyYourCouponButton;

    @FindBy(xpath = "//li[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")
    public WebElement warningMessageZeynep;

    @FindBy(xpath = "//*[text()='Coupon code applied successfully.']")
    public WebElement couponCodeIsAppliedSuccessfullyZeynep;

    @FindBy(xpath = "//*[text()='Sorry, this coupon is not applicable to selected products.']")
    public WebElement couponIsNotApplicableZeynep;

}
