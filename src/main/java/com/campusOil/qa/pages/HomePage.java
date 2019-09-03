package com.campusOil.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.campusOil.qa.base.TestBase;
import com.qa.util.java.TestUtil;


public class HomePage extends TestBase {
	

	// Page factory = Object Repository
			
	        //Campus Logo
	        @FindBy(xpath="//div[@class='logo']//a//img")
			WebElement CampusLogo;
			
			@FindBy(xpath="//div[@class='footer-logo']//img") //Footer Logo
			WebElement CampusFooterLogo;
			
			@FindBy(xpath="//ul[@class='menu parent first-level-menu']//a[contains(text(),'Home Heating')]")//Home Heating link 
			WebElement HomeHeatingLink;
			
			@FindBy(xpath="//ul[@class='menu parent first-level-menu']//a[contains(text(),'About us')]")//About Us Link
			WebElement AboutUsLink;
			
			@FindBy(xpath="//ul[@class='menu parent first-level-menu']//a[contains(text(),'Our Distributors')]")//OUR DISTRIBUTORS LINK
			WebElement OurDistributorsLink;
			
			@FindBy(xpath="//ul[@class='menu parent first-level-menu']//a[contains(text(),'My Account')]")//My Account Page
			WebElement MyAccountLink;
			
			@FindBy(xpath="//div[@class='main-menu desktop']//li[contains(@class,'menu-item menu-item-type-custom menu-item-object-custom menu-item-201')]//img")//Telephone Symbol
			WebElement TelephoneSymbol;
			
			//Telephone Number
			@FindBy(xpath="//div[@class='main-menu desktop']//a[contains(text(),'1850-839-839')]")
			WebElement TelephoneNumberLink;
			
			//Lo-cal text
			@FindBy(xpath="//div[@class='main-menu desktop']//a[contains(text(),'1850-839-839')]")
			WebElement Locallink;
			
			//Home Heating Oil Page header banner link
			@FindBy(xpath="//div[@class='page-header-background']//div[@class='container']//ul[@class='banner-menu-items']//li[@id='home-heating-oil']//div//a[contains(text(),'Home Heating Oil')]")
			WebElement HomeHeatingOilLink;
			
			//Commercial Fuels
			@FindBy(xpath="//div[@class='page-header-background']//div[@class='container']//ul[@class='banner-menu-items']//li[@id='commercial-fuels']//div//a[contains(text(),'Commercial Fuels')]")
			WebElement CommercialFuelslink;
			
			//About Us Link-2
			@FindBy(xpath ="//a[@class='button orange'][contains(text(),'About Us')]")
			WebElement AboutUsLink2;
			
			//News Link
			@FindBy(xpath="//a[@class='button orange-border-button'][contains(text(),'News')]")
			WebElement NewsLink;
			
			//Order Now Link
			@FindBy(xpath="//a[@class='button blue'][contains(text(),'Order Now')]")
			WebElement OrderNowLink;
			
			//Get Quote Link
			@FindBy(xpath="//a[@class='button blue blue-plain'][contains(text(),'Get Quote')]")
			WebElement GetQuoteLink;
			
			//**********BLOCKS AND CLICK FOR MORE LINKS****************//
			//Commercial Fuels Block - click for more link
			@FindBy(xpath="//div[contains(@class,'commercial-fuels-blocks')]//div[1]//div[1]//a[1]")
			WebElement CommercialFuelsBlockClickForMoreLink;
			
			//Agricultural Diesel Block - Click for more link
			@FindBy(xpath="//div[contains(@class,'commercial-fuels-blocks')]//div[contains(@class,'blocks')]//div[2]//div[1]//a[1]")
			WebElement AgriculturalBlockClickForMoreLink;
			
			//Marine Fuels - Click For More link
			@FindBy(xpath="//div[contains(@class,'commercial-fuels-blocks')]//div[3]//div[1]//a[1]")
			WebElement MarineFuelsClickForMoreLink;
			
			//*******************For Applying the campusoil Fuel card  - form inputs*************//
			
			//FirstName 
			@FindBy(xpath="//div[@class='fuel-card-frm']//div//input[@placeholder='First Name']")
			WebElement FuelCardFormFirstName;
			
			//LastName 
			@FindBy(xpath="//div[@class='fuel-card-frm']//div//input[@placeholder='Last Name']")
			WebElement FuelCardFormLastName;
			
			//Email
			@FindBy(xpath="//div[@class='fuel-card-frm']//div//input[@placeholder='Email']")
			WebElement FuelCardFormEmail;
			
			//Company name
			@FindBy(xpath="//div[@class='fuel-card-frm']//div//input[@placeholder='Company Name']")
			WebElement FuelCardFormCompanyName;
			
			//Quiz 
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap quiz-590']//input[@id='form-security']")
			WebElement FuelCardFormQuiz;
			
			//Get Started Button
			@FindBy(xpath="//div[contains(@class,'btn-submit')]//input[contains(@class,'wpcf7-form-control wpcf7-submit')]")
			WebElement FuelCardFormGetStartedButton;
			
			//Error field for first name
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap firstname']//span[contains(text(),'The field is required.')]")
			WebElement FuelCardFormFirstNameErrorMessage;
			
			//Error field for Last name
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap lastname']//span[contains(text(),'The field is required.')]")
			WebElement FuelCardFormLastNameErrorMessage;
			
			//Error field for email
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap email']//span[contains(text(),'The field is required.')]")
			WebElement FuelCardFormEmailErrorMessage;
			
			//Error field for Company Name
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap company']//span[contains(text(),'The field is required.')]")
			WebElement FuelCardFormCompanyErrorMessage;
			
			//Error field for quiz
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap quiz-580']//span[contains(text(),'The answer to the quiz is incorrect.')]")
			WebElement FuelCardFormQuizErrorMessage;
			
			//Error for all fields
			@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-validation-errors']")
			WebElement FuelCardFormErrorMessageAllFields;
			
			//****************SINGNUP FORM***********//
			//Mail Form First Name -Signup
			@FindBy(xpath="//div[contains(@class,'mail-form')]//div//input[contains(@name,'firstname')]")
			WebElement MailFormSignupFirstName;
			
			//Mail Form Last Name -Signup
			@FindBy(xpath="//div[contains(@class,'mail-form')]//div//input[contains(@name,'lastname')]")
			WebElement MailFormSignuplastName;
			
			//Mail Form Email -Signup
			@FindBy(xpath="//div[contains(@class,'mail-form')]//div//input[contains(@name,'email')]")
			WebElement MailFormSignupEmail;
			
			//Mail Form County -Signup
			@FindBy(xpath="//select[@id='county']")
			WebElement MailFormSignupCounty;
			
			//Mail Form Quiz -Signup
			@FindBy(xpath="//input[contains(@placeholder,'WHAT IS 6+86?')]")
			WebElement MailFormSignupQuiz;
			
			//Mail Form Signup button -Signup
			@FindBy(xpath="//input[@type='submit'][@value='Sign Up']")
			WebElement MailFormSignupbutton;
			
			//Mail Form Privacy Policy link -Signup
			@FindBy(xpath="//p[@class='join-consent']//a[contains(text(),'Privacy Policy')]")
			WebElement MailFormSignupPrivacyPolicyLink;
			
			//***************ERROR FIELDS IN SIGNUP FORM*******************//
			
			//Error field for Firstname -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap firstname']//span[contains(text(),'The field is required.')]")
			WebElement SignupCardFirstNameErrorMessage;
			
			//Error field for Lastname -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap lastname']//span[contains(text(),'The field is required.')]")
			WebElement SignupCardLastNameErrorMessage;
			
			//Error field for Email -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap email']//span[contains(text(),'The field is required.')]")
			WebElement SignupCardEmailErrorMessage;
			
			//Error field for County -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap COUNTY']//span[contains(text(),'The field is required.')]")
			WebElement SignupCardCountyErrorMessage;
			
			//Error field for Quiz -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap quiz-951']//span[contains(text(),'The field is required.')]")
			WebElement SignupCardQuizErrorMessage;
			
			//Error field for All -Signup
			@FindBy(xpath="//span[@class='wpcf7-form-control-wrap quiz-951']//span[contains(text(),'The field is required.')]")
		    WebElement SignupCardErrorMessageAllFields;
			
			//**************FOOTER LINKS***************/
			
			//Footer Menu Heading -  Your Heating Oil Supplier 
			@FindBy(xpath="//h4[contains(text(),'Your Heating Oil Supplier')]")
			WebElement FooterMenuHeadingYourHeatingOilSupplier ;
			
			//About Us Link in footer
			@FindBy(xpath="//li[@class='about-us']//a[contains(text(),'About Us')]")
			WebElement FooterAboutUsLink;
			
			//FAQs link in footer
			@FindBy(xpath="//li[@class='faqs']//a[contains(text(),'FAQs')]")
			WebElement FooterFAQsLink;
			
			//Footer Menu Heading -   Low Cost Heating Oil  
			@FindBy(xpath="//h4[contains(text(),'Low Cost Heating Oil')]")
			WebElement FooterMenuHeadingLowCostHeatingOil;
			
			//Heating Oil link in footer
			@FindBy(xpath="//li[@class='heating-oil']//a[contains(text(),'Heating Oil')]")
			WebElement FooterHeatingOilLink;
			
			//Kerosene link in footer 
			@FindBy(xpath="//li[@class='kerosene']//a[contains(text(),'Kerosene')]")
			WebElement FooterkeroseneLink;
			
			//Heating Oil Delivery link in footer
			@FindBy(xpath="//li[@class='heating-oil-delivery']//a[contains(text(),'Heating Oil Delivery')]")
			WebElement FooterHeatingOilDeliveryLink;
			
			//Marine Fuel link in footer
			@FindBy(xpath="//li[@class='marine-fuel']//a[contains(text(),'Marine Fuel')]")
			WebElement FooterMarineFuelLink;
			
			//Commercial Fuels link in footer
			@FindBy(xpath="//li[@class='commercials-fuels']//a[contains(text(),'Commercials Fuels')]")
			WebElement FooterCommercialFuelslink;
			
			//Agricultural Oil link in footer
			@FindBy(xpath="//li[@class='agricultural-oil']//a[contains(text(),'Agricultural Oil')]")
			WebElement FooterAgriculturalOilLink;
			
			//Low Cost Kerosene link in footer
			@FindBy(xpath="//li[@class='low-cost-kerosene']//a[contains(text(),'Low Cost Kerosene')]")
			WebElement FooterLowCostKeroseneLink;
			
			//Footer Menu Heading -    Ordering Heating Oil Online 
			@FindBy(xpath="//h4[contains(text(),'Ordering Heating Oil Online')]")
			WebElement FooterMenuHeadingOrderingHeatingOilOnline;
			
			//privacy policy link in footer
			@FindBy(xpath="//li[@class='privacy-policy']//a")
			WebElement FooterPrivacyPolicyLink;
			
			//Cookie Policy link in footer
			@FindBy(xpath="//li[@class='cookie-policy']//a")
			WebElement FooterCookiePolicyLink;
			
			//Terms and Conditions link in footer
			@FindBy(xpath="//li[@class='terms-and-conditions']//a")
			WebElement FooterTermsandConditionsLink;
			
			//Fuel Card Terms and Conditions in footer
			@FindBy(xpath="//li[@class='fuel-card-terms-and-conditions']//a")
			WebElement FooterFuelCardTnCLink;
			
			//Footer Menu Heading - Contact Campus Oil
			@FindBy(xpath="//h4[contains(text(),'Contact Campus Oil')]")
			WebElement FooterMenuHeadingContactCampusOil;
			
	        //Contact of Campus Oil
			@FindBy(xpath="//p[contains(text(),'La Vallee House Upper Dargle Road')]")
			WebElement FooterContactAddress;
			
			//Phone number -Footer
			@FindBy(xpath="//a[@class='phone_text']")
			WebElement FooterPhoneNumber;
			
			//Email Address - Footer
			@FindBy(xpath="//a[@class='email_text']")
			WebElement FooterEmailAddress;
			
			//MKF - Pink Patron  Logo
			@FindBy(xpath="//img[contains(@class,'footer-extra-image')]")
			WebElement FooterMKFPatronLogo;
			
            //Copyright notes on footer
			@FindBy(xpath="//div[contains(@class,'footer-bottom')]//p[1]")
			WebElement FooterCopyrightnotes;
			
			//Footer Telephone number
			@FindBy(xpath="//a[contains(text(),'1850 839 839.')]")
			WebElement FooterTelephonenumber;
			
			//Facebook link on footer
			@FindBy(xpath="//li[contains(@class,'social-icon')]//a//img")
			WebElement FooterFacebookLink;
			
			 public Timeouts pageloadTimeout = driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
			public Timeouts implicitTimeout = driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
			
	//Initializing the page objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}

	//Actions - to do
		public  boolean verifyCampusOilLogo() {
	
			return CampusLogo.isDisplayed();
		}
	
	    public boolean verifyCampusFooterLogo() {
	    	return CampusFooterLogo.isEnabled();
	    }
	    
	    public boolean VerifyLinksOnHomepage() {
	    	HomeHeatingLink.isDisplayed();
	    	AboutUsLink.isDisplayed();
	    	OurDistributorsLink.isDisplayed();
	    	MyAccountLink.isDisplayed();
	    	TelephoneSymbol.isDisplayed();
	    	return Locallink.isDisplayed();
	    }
	    
	    public boolean verifyLinkOnPageBannerHeader() {
	    	HomeHeatingOilLink.isDisplayed();
	    	return CommercialFuelslink.isDisplayed();
	    }
	    
	    public AboutUsPage verifyAboutUsLink() {
	    	pageTimeOut();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", AboutUsLink2);
	    	//AboutUsLink2.click();
	    	return new AboutUsPage();
	    }
	    
	    public NewsPage verifyNewsLink()  {
	    	pageTimeOut();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", NewsLink);
	    	//NewsLink.click();
	    	pageTimeOut();
	    	return new NewsPage();
	    }
	    
	    public OrderFormPage VerifyOrderNowLink() {
	    	pageTimeOut();
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", OrderNowLink);
	    	//OrderNowLink.click();
	    	pageTimeOut();
	    	return new OrderFormPage();
	    }
	    
  
}
