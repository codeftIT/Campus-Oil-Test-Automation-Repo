/*/*****
***author : Naresh****
******/
package com.campusOil.qa.pages;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.campusOil.qa.base.TestBase;
import com.qa.coloroutput.com.Colorme;
import com.qa.util.java.TestUtil;

import io.qameta.allure.Step;
/*import junit.framework.Assert;

import org.junit.Assert;*/

public class PlaceOrderAsRegisteredUser extends TestBase {

	public static TestBase TB;

	public static Colorme conhan;
	public static String CompareCounty;
	public static String CompareOilType;
	public static String CompareQuantity;
	public static String EmailToUse;
	public static String Firstname;
	public static String Lastname;
	public static String Landlinenumber;
	public static String MobileNumber;
	public static String toDateValidationNotSunday;
	public static String toDateValidationOnSunday;
	public static String OrderNotesverify;
	public static String UniqueFirstName;
	public static String UniqueLastName;
	public static String UniquePassword = "Test@1234";

	public static String UniquePhone;
	public static String UniqueLandline;

	// Date usage input
	static Date date = Calendar.getInstance().getTime();
	static DateFormat dateFormat = new SimpleDateFormat("dd");
	static DateFormat dateFormatTodaysDate = new SimpleDateFormat("MMMM dd, YYYY");
	// static DateFormat dateFormat2 = new SimpleDateFormat("Monthddyear");
	static String todaysDate = dateFormat.format(date);
	static String OrderDateMorph = dateFormatTodaysDate.format(date);

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddHHmmss");
	static LocalDateTime now = LocalDateTime.now();
	// System.out.println(dtf.format(now));
	public static String timeNdate = dtf.format(now);
	public static String ValidateTotalOnPages = "0";
	public static String UniqueMail = "user" + timeNdate + "@mail.com";
	// Page Factory - Object Repository

	// County dropdown selection
	@FindBy(xpath = "//select[@name='county']")
	static WebElement County;

	// Select Oil Type dropdown
	@FindBy(xpath = "//select[@name='oil_type']")
	static WebElement OilType;

	// Select litres dropdown
	@FindBy(xpath = "//select[@name='litres']")
	static WebElement Litres;

	// Get Quote button
	@FindBy(xpath = "//input[@id='orderform-submit']")
	static WebElement GetQuoteButton;

	// Cookie bar
	@FindBy(xpath = "cookie-law-info-bar")
	static WebElement Cookiebar;

	// *********Order Page**********//

	// cart form header text
	@FindBy(xpath = "//h2[@id='yourqoute-text']")
	static WebElement YourQuoteValue;

	// Order Amount field
	@FindBy(xpath = "//input[@id='order-amount-field']")
	static WebElement OrderAmountValue;

	// County field on order page
	@FindBy(xpath = "//select [@id='order-county-field']")
	static WebElement OrderpageCountyDropdown;

	// OilType field on order page
	@FindBy(xpath = "//select [@id='order-fueltype']")
	static WebElement OrderpageOilTypeDropdown;

	// Quantity field on order page
	@FindBy(xpath = "//input[@id='order-quantity-field']")
	static WebElement OrderpageQuantity;

	// Acceptance alert frame
	@FindBy(xpath = "//div[@class='ulp-layer']")
	static WebElement NotePopup;

	// Ok button on alert frame
	@FindBy(xpath = "//div[@class='ulp-layer']//a[@class='pop-up-btn-ok button blue']")
	static WebElement OkbuttonOnPopup;

	// Order Now button
	@FindBy(xpath = "//input[@type='submit'][@value='ORDER NOW']")
	static WebElement OrderNowButton;

	// Recalucalte button
	@FindBy(xpath = "//input[@type='submit'][@value='RECALCULATE']")
	static WebElement Recalculatebutton;

	// *************Login or Register page*************//

	// Register Now button
	@FindBy(xpath = "//a[@class='button white']")
	static WebElement RegisterNowbutton;

	// *************checkoutPage********************//

	// Tablist - Delivery
	@FindBy(xpath = "//a[@id='wizard-t-0']/text()")
	static WebElement Deliverytablist;

	// Your Details- Title
	@FindBy(xpath = "//select[@name='billing_nametitle']")
	static WebElement billingTitleName;

	// Your Details- First Name
	@FindBy(xpath = "//input[@name='billing_first_name']")
	static WebElement billingFirstName;

	// Your Details- Last Name
	@FindBy(xpath = "//input[@name='billing_last_name']")
	static WebElement billingLastName;

	// Your Details- Email
	@FindBy(xpath = "//input[@name='billing_email']")
	static WebElement billingEmail;

	// Your Details- Phone
	@FindBy(xpath = "//input[@name='billing_phone']")
	static WebElement billingPhone;

	// Your Details- Landline
	@FindBy(xpath = "//input[@name='billing_landline']")
	static WebElement billingLandline;

	/// Billing & Delivery Details
	// EIRCODE input for search
	@FindBy(xpath = "//div[@id='billing_autoaddresswrap']//input[@placeholder='"
			+ "Enter first line of address or Eircode & press search']")
	static WebElement SearchElementText;

	// List of search elements
	@FindBy(xpath = "//div[contains(text(),'APARTMENT A32, BLOCK A, METROPOLITAN APARTMENTS, I')]")
	static WebElement ListofSuggestions;

	// Select the option by data index
	@FindBy(xpath = "//div[@class='autoaddress-autocomplete']//descendant::div"
			+ "[@class='autoaddress-suggestion autoaddress-search'][@data-index='0']")
	static WebElement SelectOption;

	// Billing AddressLine1
	@FindBy(xpath = "//input[@name='billing_address_1']")
	static WebElement AddressInput;

	// Billing AddressLine2
	@FindBy(xpath = "//input[@name='billing_address_2']")
	static WebElement AddressLine2;

	// Billing AddressLine3
	@FindBy(xpath = "//input[@name='billing_address_3']")
	static WebElement AddressLine3;

	// Billing City
	@FindBy(xpath = "//input[@name='billing_city']")
	static WebElement AddressLine4City;

	// Billing PostCode
	@FindBy(xpath = "//input[@name='billing_postcode']")
	static WebElement PostCode;

	// Auto address completion message
	@FindBy(xpath = "//div[@class='autoaddress-options-msg success']")
	static WebElement AddressCheckMesage;

	// Close the completion message(x symbol)
	@FindBy(xpath = "//a[@class='autoaddress-close-msg']")
	static WebElement CrossIcon;

	// Billing Address 1
	@FindBy(xpath = "//input[@name='billing_address_1']")
	static WebElement BillingAddress1;

	// Billing Address 2
	@FindBy(xpath = "//input[@name='billing_address_2']")
	static WebElement BillingAddress2;

	// Billing Address 3
	@FindBy(xpath = "//input[@name='billing_address_3']")
	static WebElement BillingAddress3;

	// Billing City
	@FindBy(xpath = "//input[@name='billing_city']")
	static WebElement BillingCity;

	// Billing PostCode
	@FindBy(xpath = "//input[@name='billing_postcode']")
	static WebElement BillingPostCode;

	// CalendarBox, NextLinkButton, MidLink, PreviousButtonLink, ListOfMonths,
	// ListAllDates

	// CalendarBox
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//tbody")
	static WebElement CalendarBox;

	// date selection
	@FindBy(xpath = "//*[@class='ui-datepicker-calendar']/tbody/tr/td/a")
	static List<WebElement> SelectDay;

	/*
	 * //Date prefilled
	 * 
	 * @FindBy(xpath=
	 * "/html[1]/body[1]/main[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/p[6]/span[1]/input[@id='datepicker']")
	 * static WebElement DatePrefilled;
	 */

	// Ship to different address checkbox
	@FindBy(xpath = "//input[@id='ship-to-different-address-checkbox']")
	static WebElement CheckboxforDifferentAddress;

	// Delivering to different address text
	@FindBy(xpath = "//h2[contains(text(),'Delivering to a different address?')]")
	static WebElement DifferentAddresstext;

	/// shipping Delivery Details
	// EIRCODE input for search
	@FindBy(xpath = "//div[@id='shipping_autoaddresswrap']//input[@class='autoaddress-text-box']")
	static WebElement SearchElementText_shippingaddress;

	// List of search elements
	@FindBy(xpath = "//div[@id='shipping_autoaddresswrap']//div[@class='autoaddress-control']"
			+ "//div[@class='autoaddress-autocomplete']//descendant::"
			+ "div[contains(text(),'PORTVIEW HOUSE, THORNCASTLE STREET, DUBLIN 4')]")
	static WebElement ListofSuggestions_shippingaddress;

	// Info message
	@FindBy(xpath = "//div[@class='autoaddress-options-msg info']")
	static WebElement InfoMessage;

	// Options for address
	@FindBy(xpath = "//div[@class='autoaddress-options-list']//ul//li[@class='autoaddress-options-item']"
			+ "//a[contains(text(),'CONNELLY PARTNERS DUBLIN, PORTVIEW HOUSE, THORNCASTLE STREET, DUBLIN 4')]")
	static WebElement OptionsForAddress;

	// Select the option by data index
	@FindBy(xpath = "//div[@class='autoaddress-autocomplete']//descendant::div"
			+ "[@class='autoaddress-suggestion autoaddress-search'][@data-index='0']")
	static WebElement SelectOption_shippingaddress;

	// Auto address completion message
	@FindBy(xpath = "//div[@class='autoaddress-options-msg success']")
	static WebElement AddressCheckMesage_shippingaddress;

	// Close the completion message(x symbol)
	@FindBy(xpath = "//a[@class='autoaddress-close-msg']")
	static WebElement CrossIcon_shippingaddress;

	// Billing Address 1
	@FindBy(xpath = "//input[@name='shipping_address_1']")
	static WebElement shippingAddress1;

	// Billing Address 2
	@FindBy(xpath = "//input[@name='shipping_address_2']")
	static WebElement shippingAddress2;

	// Billing Address 3
	@FindBy(xpath = "//input[@name='shipping_address_3']")
	static WebElement shippingAddress3;

	// Billing City
	@FindBy(xpath = "//input[@name='shipping_city']")
	static WebElement shippingCity;

	// Billing PostCode
	@FindBy(xpath = "//input[@name='shipping_postcode']")
	static WebElement shippingPostCode;

	// createPassword
	@FindBy(xpath = "//input[@name='account_password']")
	static WebElement CreatePassword;

	// ConfirmPassword
	@FindBy(xpath = "//input[@name='account_password-2']")
	static WebElement ConfirmPassword;

	// OrderNotes
	@FindBy(xpath = "//input[@id='order_comments']")
	static WebElement OrderNotes;

	// Email checkbox in marketing permissions
	@FindBy(xpath = "//input[@name='billing_marketingemail']")
	static WebElement EmailCheckbox;

	// SMS checkbox in marketing permissions
	@FindBy(xpath = "//input[@name='billing_marketingsms']")
	static WebElement SMSCheckbox;

	// Phone checkbox in marketing permissions
	@FindBy(xpath = "//input[@name='billing_marketingphone']")
	static WebElement PhoneCheckbox;

	// Order Summary - Oil Type
	@FindBy(xpath = "//div[@id='order-summary-box']//descendant::div[@class='summary-row order-fueltype']//descendant::p[@class='rightitem']")
	static WebElement OilTypeInOrderSummary;

	// Order Summary - Litres
	@FindBy(xpath = "//div[@id='order-summary-box']//descendant::div[@class='summary-row order-quantity']//descendant::div[@class='rightitem']//descendant::p[@class='title']")
	static WebElement LitresInOrderSummary;

	// Order Summary - Subtotal
	@FindBy(xpath = "//div[@id='order-summary-box']//descendant::div[@class='cart-subtotal']//descendant::p[1]//span[1]")
	static WebElement SubtotalInOrderSummary;

	// Order Summary - OrderTotal
	@FindBy(xpath = "//div[@id='order-summary-box']//descendant::div[@class='order-total']//descendant::div[@class='rightitem']//p[@class='title']")
	static WebElement OrderTotalInOrderSummary;

	// Continue button after completion
	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	static WebElement ContinueToPayment;

	// Tablist - Payment
	@FindBy(xpath = "//a[@id='wizard-t-1']")
	static WebElement Paymenttablist;

	// Card Number
	@FindBy(xpath = "//input[@id='realex_accountNumber']")
	static WebElement CardNumber;

	// Card Type
	@FindBy(xpath = "//select[@id='realex_cardType']")
	static WebElement CardTypeinput;

	// Expiry Month
	@FindBy(xpath = "//select[@id='realex_expirationMonth']")
	static WebElement ExpiryMonthinput;

	// Expiry Year
	@FindBy(xpath = "//select[@id='realex_expirationYear']")
	static WebElement ExpiryYearinput;

	// CVV number
	@FindBy(xpath = "//input[@id='realex_cvNumber']")
	static WebElement CVVinput;

	// AcceptTerms and condition
	@FindBy(xpath = "//input[@id='terms']")
	static WebElement AcceptConditionsCheckbox;

	// Place Order
	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	static WebElement PlaceOrderButton;

	/// popup for login

	// Popup
	@FindBy(xpath = "//div[@class='woo-login-popup-sc-modal-inner']")
	static WebElement PopupDisplayed;

	// Username
	@FindBy(xpath = "//div[@class='woo-login-popup-sc-left']//div[@id='woo-login-popup-sc-login']//form//p[1]//input[@name='username']")
	static WebElement PopupUsername;

	// Password
	@FindBy(xpath = "//div[@class='woo-login-popup-sc-left']//div[@id='woo-login-popup-sc-login']//form//p[2]//input[@name='password']")
	static WebElement PopupPassword;

	// Login button
	@FindBy(xpath = "//div[@class='woo-login-popup-sc-left']//div[@id='woo-login-popup-sc-login']//form[@class='login']//input[@name='login']")
	static WebElement PopupLoginButton;

	// FadeOut On click
	@FindBy(xpath = "//div[@class='ulp-overlay ulp-animated ulp-fadeIn']")
	static WebElement FadeOutOnClick;

	// *************Order Confirmation Page****************
	// Confirmation tab
	@FindBy(xpath = "//a[@id='wizard-t-0']/text()")
	static WebElement ConfirmationTab;

	// Thank you message
	@FindBy(xpath = "//h2[contains(text(),'Thank you. Your order has been received.')]")
	static WebElement ThankYouMessage;

	// Order Number and text
	@FindBy(xpath = "//ul//li[@class='order']")
	static WebElement OrderNumberAndText;

	// OrderNumber
	@FindBy(xpath = "//ul//li[@class='order']//strong")
	static WebElement OrderRefernceNumber;

	// Date text
	@FindBy(xpath = "//ul//li[@class='date']")
	static WebElement DateAndText;

	// OrderNumber
	@FindBy(xpath = "//ul//li[@class='date']//strong")
	static WebElement OrderDate;

	// Requested delivery date text
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Requested Delivery Date:')]")
	static WebElement RequestedDeliveryDateAndText;

	// Delivery Date
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Requested Delivery Date:')]//strong")
	static WebElement RequestedDeliveryDate;

	// Order Notes text
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Order Notes:')]")
	static WebElement OrderNotesAndText;

	// Order Notes
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Order Notes:')]//strong")
	static WebElement OrderNotesValue;

	// Order total and text
	@FindBy(xpath = "//ul//li[@class='total']")
	static WebElement OrderTotalAndText;

	// Order total value
	@FindBy(xpath = "//ul//li[@class='total']//strong")
	static WebElement OrderTotalValue;

	// Payment Method and Text
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Payment method:')]")
	static WebElement PaymentMethodAndText;

	// Payment Method
	@FindBy(xpath = "//ul//li[@class='method'][contains(text(),'Payment method:')]//strong")
	static WebElement PaymentMethod;

	// ******Order Details*******

	// County value and text
	@FindBy(xpath = "//ul//li[@class='county']")
	static WebElement CountyAndText;

	// County value
	@FindBy(xpath = "//ul//li[@class='county']//strong")
	static WebElement CountyOnOrderConfPage;

	// Fuel Type value and text
	@FindBy(xpath = "//ul//li[@class='fuel-type']")
	static WebElement FuelTypeAndText;

	// Fuel Type Value
	@FindBy(xpath = "//ul//li[@class='fuel-type']//strong")
	static WebElement FuelTypeOnOrderConfPage;

	// Quantity text and value
	@FindBy(xpath = "//ul//li[@class='quantity']")
	static WebElement QuantityValueAndText;

	// Quanitity value
	@FindBy(xpath = "//ul//li[@class='quantity']//strong")
	static WebElement QuantityValueOnOrderConfPage;

	// Amount value and text
	@FindBy(xpath = "//ul//li[@class='amount']")
	static WebElement AmountValueAndText;

	// Amount Value
	@FindBy(xpath = "//ul//li[@class='amount']//strong")
	static WebElement AmountValueOnOrderConfPage;

	// ********Customer Details

	// Email Of Customer
	@FindBy(xpath = "//div[@class='woocommerce-column woocommerce-column--1 woocommerce-column--"
			+ "billing-address']//p[@class='woocommerce-customer-details--email']")
	static WebElement EmailOfCustomer;

	// Phone number
	@FindBy(xpath = "//div[@class='woocommerce-column woocommerce-column--1 woocommerce-column--"
			+ "billing-address']//p[@class='woocommerce-customer-details--phone']")
	static WebElement PhoneOfCustomer;

	// Title of billing address
	@FindBy(xpath = "//p[@class='woocommerce-column__title'][contains(text(),'Billing')]")
	static WebElement TitleBillingAddress;

	// Billing address
	@FindBy(xpath = "//address[1]")
	static WebElement BillingAddress;

	// Title of Delivery address
	@FindBy(xpath = "//p[@class='woocommerce-column__title'][contains(text(),'Delivery')]")
	static WebElement TitleDeliveryAddress;

	// Delivery Address
	@FindBy(xpath = "//address[2]")
	static WebElement DeliveryAddress;

	public PlaceOrderAsRegisteredUser() {
		PageFactory.initElements(driver, this);
		System.out.println(Colorme.GREEN_BOLD_BRIGHT
				+ "*****Test for placing Order as Registered and UnRegistered Users both is intialized****"
				+ Colorme.RESET);
	}

	// Verify the Country dropdown
	@Step("Selecting the country dropdown")
	public static void countyDropdown() {
		if (prop.getProperty("browser") == "mobile") {

		}
		// Verify the County enabled or not
		County.isEnabled();
		System.out.println(Colorme.GREEN_BOLD_BRIGHT + "*****County dropdown is enabled****" + Colorme.RESET);

		// Click on County Dropdown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", County);
		System.out.println(Colorme.GREEN_BOLD_BRIGHT + "*****County dropdown is opened****" + Colorme.RESET);
		implicitTimeOut();

		// Make the select statement apply on Dropdown
		Select CountySelection = new Select(County);
		CountySelection.selectByVisibleText("Dublin");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "****County is selected****" + Colorme.RESET);
		implicitTimeOut();

		// Getting the selected option
		CompareCounty = CountySelection.getFirstSelectedOption().getText();
		System.out.println(CompareCounty);
		implicitTimeOut();
	}

	// Verify the Selction of oil type
	@Step("Selecting the OilType Dropdown")
	public static void SelectOilTypeDropdown() {

		// Verify the Oiltype enabled or not
		OilType.isEnabled();

		// Click on OilType Dropdown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", OilType);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Oil Type dropdown is selected****" + conhan.RESET);

		// Scroll the screen
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Scrolled down****" + conhan.RESET);
		implicitTimeOut();

		// Make the select statement apply on Dropdown
		Select OilTypeSelection = new Select(OilType);
		OilTypeSelection.selectByVisibleText("Kerosene");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****OilType is selected****" + conhan.RESET);

		// Getting the selected option
		CompareOilType = OilTypeSelection.getFirstSelectedOption().getText();
		System.out.println(CompareOilType);
		implicitTimeOut();
	}

	// Verify the Selction of litres
	@Step("Selecting the Litres Dropdown")
	public static void SelectLitresDropdown() {

		// Verify the litres enabled or not
		Litres.isEnabled();
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Litres dropdown is enabled****" + conhan.RESET);

		// Click on litres Dropdown
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Litres);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Litres dropdown is clicked****" + conhan.RESET);
		implicitTimeOut();

		// Make the select statement apply on Dropdown
		Select litresSelection = new Select(Litres);
		litresSelection.selectByVisibleText("300");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Selected the option from dropdown****" + conhan.RESET);

		// Getting the selected option
		CompareQuantity = litresSelection.getFirstSelectedOption().getText();
		System.out.println(CompareQuantity);
		implicitTimeOut();
	}

	// Verify the GetQuote button and URL
	@Step("Clicking on the GetQuote button")
	public static void GetQuote() {

		// Click on Get Quote button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", GetQuoteButton);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Clicked on Get Quote button****" + conhan.RESET);
	}

	@Step("Verifying the OrderPage")
	public static void OrderPage() {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Navigated to Order Page****" + conhan.RESET);
		// Get the text and value on header
		String Cartformheadertext = YourQuoteValue.getText();
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Your Quote text value is captured****" + conhan.RESET);
		// System.out.println(Cartformheadertext);
		// String splitter to get value from string
		String a[] = Cartformheadertext.split(" ");

		// print elements of String array
		for (int i = 0; i < a.length; i++)
			;

		// String containing the value of text
		String quotevaluetext = a[3];
		System.out.println(conhan.GREEN_BOLD_BRIGHT
				+ "*****Integer value from Your quote text is captured into an array****" + conhan.RESET);
		// String b[] = quotevaluetext.split("€");

		TestUtil.implicitTimeOut();

		// Get the amount of the value and convert into double value
		String CartAmountvaluetext = "€" + OrderAmountValue.getAttribute("value");
		// Double CartAmountValue = new Double(CartAmountvaluetext) ;
		// System.out.println(CartAmountvaluetext);

		// compare the changeable amount and prefilled amount
		Assert.assertEquals(CartAmountvaluetext, quotevaluetext);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Camparing the order totals****" + conhan.RESET);

		// Assigning to a varaible for further use
		ValidateTotalOnPages = quotevaluetext;
	}

	// Validating the field of county with homepage selection and the option
	// prefilled in order page
	@Step("Validating the county")
	public static void countyValidation() {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validation method for county****" + conhan.RESET);
		Select Countyinput = new Select(OrderpageCountyDropdown);
		String Countyprefilledinput = Countyinput.getFirstSelectedOption().getText().toUpperCase();
		// System.out.println(Countyprefilledinput+" "+CompareCounty);

		Assert.assertEquals(CompareCounty, Countyprefilledinput);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****County is validated****" + conhan.RESET);
	}

	// Validating the field of oiltype with homepage selection and the option
	// prefilled in order page
	@Step("Validating the OilType")
	public static void OiltypeValidation() {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Oil type validation method****" + conhan.RESET);
		Select OilTypeinput = new Select(OrderpageOilTypeDropdown);
		String OilTypeprefilledinput = OilTypeinput.getFirstSelectedOption().getText().toUpperCase();
		// System.out.println(OilTypeprefilledinput+" "+CompareOilType);

		Assert.assertEquals(CompareOilType, OilTypeprefilledinput);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Oil type is validated****" + conhan.RESET);

	}

	// Validating the field of oiltype with homepage selection and the option
	// prefilled in order page
	@Step("Validating the Quantity")
	public static void QuantityValidation() {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Quantity validation method****" + conhan.RESET);
		String Quantityprefilledinput = OrderpageQuantity.getAttribute("value");
		// System.out.println(Quantityprefilledinput+" "+CompareQuantity);

		Assert.assertEquals(CompareQuantity, Quantityprefilledinput);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Quantity field is validated****" + conhan.RESET);

	}

	// OrderNow button
	@Step("Click on OrderNow button")
	public static void OrderNow() {
		OrderNowButton.click();
		System.out.println(conhan.GREEN_BOLD_BRIGHT
				+ "*****Clicked on order now button redirects to Login and Register page****" + conhan.RESET);
	}

	// Register Now button
	@Step("Click on the Register now button")
	public static RegistrationPage RegisterPage() {
		RegisterNowbutton.click();
		System.out.println(conhan.GREEN_BOLD_BRIGHT
				+ "*****Cliked on Register now button redirects to checkout page****" + conhan.RESET);
		return new RegistrationPage();
	}

	// To Enter the Your Details on checkout
	@Step("To Enter the user details")
	public static void YourDetails(String title, String Phone, String landline) throws InterruptedException {
		// Scroll the screen
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Scroll the screen****" + conhan.RESET);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		// Input to title name
		Select titlename = new Select(billingTitleName);
		titlename.selectByValue(title);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Title name is selected from dropdown****" + conhan.RESET);

		// input to firstname
		Firstname = "first" + timeNdate;
		billingFirstName.sendKeys(Firstname);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Firstname is entered into field****" + conhan.RESET);

		// input to lastname
		Lastname = "second" + timeNdate;
		billingLastName.sendKeys(Lastname);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Lastname is entered into field****" + conhan.RESET);

		// input to email - Here Email is verified and if email is already is exists
		// popup open
		// for the login
		EmailToUse = "user" + timeNdate + "@mail.com";
		billingEmail.sendKeys(EmailToUse);
		billingEmail.sendKeys(Keys.TAB);
		UniqueMail = EmailToUse;

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Email value is entered and validates for existing user****"
				+ conhan.RESET);

		Thread.sleep(4000);

		// input to Phone
		billingPhone.sendKeys(Phone);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Phone number is entered****" + conhan.RESET);
		UniquePhone = Phone;

		Thread.sleep(2000);
		// input to landline
		billingLandline.sendKeys(landline);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Landline number is entered****" + conhan.RESET);
		UniqueLandline = landline;
	}

	@Step("To Enter the Billing Address  details")
	public static void BillingAndDeliveryDetails() throws InterruptedException {

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Search for the billing address****" + conhan.RESET);
		// Send input on search
		SearchElementText.sendKeys("A32");
		Thread.sleep(3000);

		ListofSuggestions.click();
		Thread.sleep(5000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Billing address is entered****" + conhan.RESET);
		Assert.assertEquals(AddressCheckMesage.getText(), "Postcode Found, address populated below.");
		Thread.sleep(2000);

		CrossIcon.click();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		System.out
				.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing address prefilled****" + conhan.RESET);
		Assert.assertEquals(BillingAddress1.getAttribute("value"), "APARTMENT A32");
		Thread.sleep(2000);

		Assert.assertEquals(BillingAddress2.getAttribute("value"), "BLOCK A");
		Thread.sleep(2000);

		Assert.assertEquals(BillingAddress3.getAttribute("value"), "METROPOLITAN APARTMENTS");
		Thread.sleep(2000);

		Assert.assertEquals(BillingCity.getAttribute("value"), "INCHICORE ROAD");
		Thread.sleep(2000);

		Assert.assertEquals(BillingPostCode.getAttribute("value"), "D08C567");
		Thread.sleep(2000);
		// System.out.println("content >> " + cell.getText());
	}

	/// Delivering to a different address
	@Step("To Enter the Delivery Address details")
	public static void toDeliverDifferentAddress() throws InterruptedException {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Scroll the screen****" + conhan.RESET);
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		CheckboxforDifferentAddress.click();
		Thread.sleep(1000);

		ExpectedCondition<WebElement> waitFortext = ExpectedConditions.visibilityOf(DifferentAddresstext);

		// Send input on search
		SearchElementText_shippingaddress.sendKeys("portview");
		Thread.sleep(3000);
		ListofSuggestions_shippingaddress.click();
		Thread.sleep(3000);

		OptionsForAddress.click();
		Thread.sleep(2000);
		/*
		 * Assert.assertEquals("Please select an option below", InfoMessage.getText());
		 * Thread.sleep(1000);
		 */

		Assert.assertEquals(AddressCheckMesage_shippingaddress.getText(), "Postcode Found, address populated below.");
		Thread.sleep(2000);

		CrossIcon_shippingaddress.click();
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Shipping address is entered****" + conhan.RESET);

		((JavascriptExecutor) driver).executeScript("scroll(0,50)");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****screen is scrolled down****" + conhan.RESET);
		Assert.assertEquals(shippingAddress1.getAttribute("value"), "CONNELLY PARTNERS DUBLIN");
		Thread.sleep(2000);

		Assert.assertEquals(shippingAddress2.getAttribute("value"), "PORTVIEW HOUSE");
		Thread.sleep(2000);

		Assert.assertEquals(shippingAddress3.getAttribute("value"), "THORNCASTLE STREET");
		Thread.sleep(2000);

		Assert.assertEquals(shippingCity.getAttribute("value"), "DUBLIN 4");
		Thread.sleep(5000);

		Assert.assertEquals(shippingPostCode.getAttribute("value"), "D04V9Y9");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Shipping address is validated****" + conhan.RESET);
	}

	@Step("To Enter the Required Delivery Date")
	public static void DateInput() throws InterruptedException {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Method to enter the date****" + conhan.RESET);
		// Grab the calendar and then enter the date of tomorrow
		WebElement table = CalendarBox;
		// DatePrefilled.click();
		Thread.sleep(2000);
		// Now get all the TR elements from the table
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		// And iterate over them, getting the cells
		List<WebElement> cells = table.findElements(By.tagName("td"));
		Thread.sleep(2000);

		// Scroll the screen
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		for (WebElement cell : cells) {
			Date date = Calendar.getInstance().getTime();
			DateFormat dateFormat = new SimpleDateFormat("dd");
			DateFormat dateFormat2 = new SimpleDateFormat("MMMM");
			DateFormat dateFormat3 = new SimpleDateFormat("YYYY");
			String strDate = dateFormat.format(date);
			String strDate1 = dateFormat2.format(date);
			String strDate2 = dateFormat3.format(date);

			Format formatter = new SimpleDateFormat("MMMM");
			String s = formatter.format(new Date());
			// System.out.println(s);

			int date1 = Integer.parseInt(strDate);
			// System.out.println(date1+1);
			int day = date.getDay(); /// deprecated method but can be used by suppress warnings

			// if Sunday then add the date with day the of next
			if (day != 0) {
				date1 = date1 + 1;
				String date2 = String.valueOf(date1);
				if (cell.getText().equals(date2)) {
					cell.findElement(By.linkText(date2)).click();
					// System.out.println("clicked on date" + date2);
					Thread.sleep(5000);

					Format formater = new SimpleDateFormat("MMMM ");
					Format formater1 = new SimpleDateFormat(" YYYY");
					String two = formater.format(new Date());
					String three = formater1.format(new Date());
					String op1 = two + date2 + "," + three;
					System.out.println(op1);
					toDateValidationNotSunday = op1;
					System.out.println(toDateValidationNotSunday);
					// toDateValidationNotSunday =strDate2+date2+","+strDate;
					break;
				}
			} else {
				date1 = date1 + 2;
				String date2 = String.valueOf(date1);
				if (cell.getText().equals(date2)) {
					cell.findElement(By.linkText(date2)).click();
					System.out.println("clicked on date" + date2);

					Format formater = new SimpleDateFormat("MMMM ");
					Format formater1 = new SimpleDateFormat(" YYYY");
					String two = formater.format(new Date());
					String three = formater1.format(new Date());
					String op = two + date2 + "," + three;
					System.out.println(op);
					toDateValidationOnSunday = op;
					System.out.println(toDateValidationOnSunday);
					// toDateValidationOnSunday =strDate2+date2+","+strDate;
					break;
				}
			}
		}

	}

	@Step("To Enter the Password : Test@1234")
	public static void passwordInput() throws InterruptedException {
		System.out.println(
				conhan.GREEN_BOLD_BRIGHT + "*****Enter the password and Confirm the password****" + conhan.RESET);
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		UniquePassword = "Test@1234";
		CreatePassword.sendKeys(UniquePassword);
		Thread.sleep(1000);
		ConfirmPassword.sendKeys(UniquePassword);
	}

	@Step("To Enter the OrderNotes")
	public static void OrderNotesInput() {
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		OrderNotesverify = "Testorder" + timeNdate;
		OrderNotes.sendKeys(OrderNotesverify);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Testorder notes is entered****" + conhan.RESET);
	}

	@Step("To check the Marketing permissions")
	public static void MarketingPermissions() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		EmailCheckbox.click();
		Thread.sleep(1000);
		SMSCheckbox.click();
		Thread.sleep(1000);
		PhoneCheckbox.click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		Thread.sleep(1000);
		ContinueToPayment.click();
		Thread.sleep(10000);
		// ExpectedCondition<WebElement> waitForPaymentTablist =
		// ExpectedConditions.visibilityOf(Paymenttablist);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Marketing permissions are allowed****" + conhan.RESET);
	}

	@Step("Verifying the Order summary details")
	public static void toVerifyOrderSummary() throws InterruptedException {

		Assert.assertEquals(CompareOilType.toLowerCase(),
				OilTypeInOrderSummary.getAttribute("innerText").toLowerCase());
		Assert.assertEquals(CompareQuantity.toLowerCase(),
				LitresInOrderSummary.getAttribute("innerText").toLowerCase());
		String total = ValidateTotalOnPages;
		/*
		 * System.out.println(OilTypeInOrderSummary.getAttribute("innerText"));
		 * System.out.println(LitresInOrderSummary.getAttribute("innerText"));
		 * System.out.println(SubtotalInOrderSummary.getAttribute("innerText"));
		 * System.out.println(OrderTotalInOrderSummary.getAttribute("innerText"));
		 */ Assert.assertEquals(total, SubtotalInOrderSummary.getAttribute("innerText"));
		Assert.assertEquals(total, OrderTotalInOrderSummary.getAttribute("innerText"));
		System.out
				.println(conhan.GREEN_BOLD_BRIGHT + "*****Verified the Order Summary on right side****" + conhan.RESET);

		Thread.sleep(4000);
		Paymenttablist.isDisplayed();
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Enters the payment page****" + conhan.RESET);
		ValidateTotalOnPages = total;
	}

	// Verify the value of changes with importing the excel data into the dropdowns
	// and inputs
	@Step("Verify the value of changes with importing the excel data into the dropdowns and inputs")
	public static void toVerifyTheValuesAfterChange(String County, String OilType, String Quantity, String Amount)
			throws InterruptedException {
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Scroll the screens****" + conhan.RESET);
		// Scroll the screen
		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		Select CountySelection = new Select(OrderpageCountyDropdown);
		CountySelection.selectByValue(County);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Changed the County value as required****" + conhan.RESET);

		Select OilTypeSelection = new Select(OrderpageOilTypeDropdown);
		OilTypeSelection.selectByValue(OilType);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Changed the OilType as required****" + conhan.RESET);

		try {
			OkbuttonOnPopup.click();
		} catch (NoSuchElementException e) {
			// System.out.println("No popup here");
		}

		// clear the quantity field and send keys to field
		OrderpageQuantity.clear();
		OrderpageQuantity.sendKeys(Quantity);

		// Thread.sleep(10000);

		// Click on the recalculate
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Recalculatebutton);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Recaluculate button is clicked****" + conhan.RESET);
		// String QuantityExpected = Quantity;
		String AmountExpected = Amount;

		// String QuantityActual = OrderpageQuantity.getAttribute("value");
		String AmountActual = OrderAmountValue.getAttribute("value");

		// Assert.assertEquals(QuantityExpected, QuantityActual);
		Assert.assertEquals(AmountExpected, AmountActual);
		System.out.println(
				conhan.GREEN_BOLD_BRIGHT + "*****Order Total after the changes is validated****" + conhan.RESET);

	}

	/// PaymentDetails Method
	@Step("To Enter Payment details ")
	public static void Payment() throws InterruptedException {

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Enter the card number****" + conhan.RESET);
		CardNumber.sendKeys(prop.getProperty("CardNumber_Visa"));
		Thread.sleep(2000);

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Select the card type****" + conhan.RESET);
		Select Cardtype = new Select(CardTypeinput);
		Cardtype.selectByValue(prop.getProperty("cardtype"));
		Thread.sleep(2000);

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Select the month****" + conhan.RESET);
		Select Expirymonth = new Select(ExpiryMonthinput);
		Expirymonth.selectByValue(prop.getProperty("Month"));
		Thread.sleep(2000);

		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Select the expiry year****" + conhan.RESET);
		Select Expiryyear = new Select(ExpiryYearinput);
		Expiryyear.selectByValue(prop.getProperty("Year"));

		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		Thread.sleep(2000);
		CVVinput.sendKeys(prop.getProperty("CVV"));
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****CVV is entered****" + conhan.RESET);

		Thread.sleep(2000);

		AcceptConditionsCheckbox.click();
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Terms and conditions are accepeted****" + conhan.RESET);

		toVerifyOrderSummary();
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Order Summary is verified****" + conhan.RESET);

		Thread.sleep(1000);
		PlaceOrderButton.click();
		Thread.sleep(30000);

	}

	/// When User is already Registered then can take the method
	@Step("Verifying the User is registered or not If yes then pop us displayed")
	public static void AsRegisteredUser() throws InterruptedException {
		System.out.println(
				conhan.GREEN_BOLD_BRIGHT + "*****Place Order As Registered User is intialized****" + conhan.RESET);
		String TestEmail = "naresh@mail.com";
		System.out.println(conhan.GREEN_BOLD_BRIGHT
				+ "*****Enter the email and validate the user and popup displays for existing user to login****"
				+ conhan.RESET);
		billingEmail.sendKeys(UniqueMail);
		billingEmail.sendKeys(Keys.TAB);
		Thread.sleep(4000);

		ExpectedCondition<WebElement> waitForPopup = ExpectedConditions.visibilityOf(PopupDisplayed);
		Thread.sleep(2000);

		PopupUsername.sendKeys(UniqueMail);
		Thread.sleep(2000);
		PopupPassword.sendKeys(UniquePassword);
		Thread.sleep(2000);
		PopupLoginButton.click();
		Thread.sleep(2000);

		// FadeOutOnClick.click();
	}

	@Step("Verifying the Order Confirmation Page")
	public static void OrderConfirmationPage() throws InterruptedException {

		ExpectedCondition<WebElement> waitForTablist = ExpectedConditions.visibilityOf(ConfirmationTab);
		Thread.sleep(3000);

		if (ThankYouMessage.isDisplayed()) {
			System.out
					.println(conhan.PURPLE_BACKGROUND_BRIGHT + "*****SUCCESFULLY PLACED THE ORDER****" + conhan.RESET);
		} else {
			System.out.println(conhan.RED_UNDERLINED + "*****UNABLE TO PLACE THE ORDER****" + conhan.RESET);
		}
		// ConfirmationTab.isDisplayed();
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Order Confirmation page is displayed****" + conhan.RESET);
		ThankYouMessage.isDisplayed();
		Thread.sleep(2000);

		OrderNumberAndText.isDisplayed();
		String OrderReferenceNumber = OrderRefernceNumber.getText();

		DateAndText.isDisplayed();
		Thread.sleep(2000);
		String DateOfOrder = OrderDate.getText();
		System.out.println(DateOfOrder);
		System.out.println(OrderDateMorph);
		// Assert.assertEquals(OrderDateMorph,DateOfOrder );

		OrderDateVerificationOnOrderConfPage();

		OrderNotesAndText.isDisplayed();
		String OrderNotes = OrderNotesValue.getText();
		Assert.assertEquals(OrderNotes, OrderNotesverify);

		OrderTotalAndText.isDisplayed();
		Thread.sleep(2000);
		String OrderTotal = OrderTotalValue.getText();
		Assert.assertEquals(OrderTotal, ValidateTotalOnPages);

		PaymentMethodAndText.isDisplayed();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		CountyAndText.isDisplayed();
		Thread.sleep(2000);
		String CountyValue = CountyOnOrderConfPage.getText();
		Assert.assertEquals(CountyValue.toLowerCase(), CompareCounty.toLowerCase());

		FuelTypeAndText.isDisplayed();
		Thread.sleep(2000);
		String FuelTypeValue = FuelTypeOnOrderConfPage.getText();
		Assert.assertEquals(FuelTypeValue.toLowerCase(), CompareOilType.toLowerCase());

		QuantityValueAndText.isDisplayed();
		Thread.sleep(2000);
		String QuantityValue = QuantityValueOnOrderConfPage.getText();
		Assert.assertEquals(QuantityValue, CompareQuantity);

		AmountValueAndText.isDisplayed();
		Thread.sleep(2000);
		String AmountValue = AmountValueOnOrderConfPage.getText();
		Assert.assertEquals(AmountValue, ValidateTotalOnPages);

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		EmailOfCustomer.isDisplayed();
		Thread.sleep(2000);

		PhoneOfCustomer.isDisplayed();
		Thread.sleep(2000);

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");

		TitleBillingAddress.isDisplayed();
		Thread.sleep(2000);

		BillingAddress.isDisplayed();
		Thread.sleep(2000);
		String BilAddress = BillingAddress.getText();
		String billAdd[] = BilAddress.split("\n");

		// print elements of String array
		for (int i = 0; i < billAdd.length; i++)
			;

		String billAdd1 = billAdd[1];

		String billAdd2 = billAdd[2];
		String billAdd3 = billAdd[3];
		String billCity = billAdd[4];
		String billCode = billAdd[5];

		/*
		 * System.out.println("a[0]= "+billAdd[0]);
		 * System.out.println("a[1]="+billAdd[1]);
		 * System.out.println("a[2]="+billAdd[2]);
		 * System.out.println("a[3]="+billAdd[3]);
		 * System.out.println("a[4]="+billAdd[4]);
		 * System.out.println("a[5]="+billAdd[5]);
		 */
		String FirstLastNames = billAdd[0];
		String FirstLast[] = FirstLastNames.split(" ");

		for (int j = 0; j < FirstLast.length; j++)
			;

		//// Verify billing address with address on Recent pages.

		System.out
				.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing address prefilled****" + conhan.RESET);
		Assert.assertEquals(billAdd1, "APARTMENT A32");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing address1****" + conhan.RESET);
		Assert.assertEquals(billAdd2, "BLOCK A");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing address2****" + conhan.RESET);
		Assert.assertEquals(billAdd3, "METROPOLITAN APARTMENTS");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing address3****" + conhan.RESET);
		Assert.assertEquals(billCity, "INCHICORE ROAD");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing City****" + conhan.RESET);
		Assert.assertEquals(billCode, "D08C567");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the billing pin code****" + conhan.RESET);

		DeliveryAddress.isDisplayed();
		Thread.sleep(3000);
		String DelAddress = DeliveryAddress.getText();
		String delAdd[] = DelAddress.split("\n");

		for (int i = 0; i < delAdd.length; i++)
			;

		/*
		 * System.out.println("a[0]= "+delAdd[0]);
		 * System.out.println("a[1]="+delAdd[1]); System.out.println("a[2]="+delAdd[2]);
		 * System.out.println("a[3]="+delAdd[3]);
		 */

		String delAdd1 = delAdd[0];
		String delAdd2 = delAdd[1];
		// String delAdd3 = delAdd[];
		String delCity = delAdd[2];
		String delCode = delAdd[3];

		((JavascriptExecutor) driver).executeScript("scroll(0,200)");
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****screen is scrolled down****" + conhan.RESET);
		Assert.assertEquals(delAdd1, "CONNELLY PARTNERS DUBLIN");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the shipping address1*****" + conhan.RESET);
		Assert.assertEquals(delAdd2, "PORTVIEW HOUSE");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the shipping address2*****" + conhan.RESET);
		/*
		 * Assert.assertEquals(delAdd3, "THORNCASTLE STREET"); Thread.sleep(2000);
		 */

		Assert.assertEquals(delCity, "DUBLIN 4");
		Thread.sleep(5000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the shipping city*****" + conhan.RESET);
		Assert.assertEquals(delCode, "D04V9Y9");
		Thread.sleep(2000);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Validating the shipping pin code*****" + conhan.RESET);
		System.out.println(conhan.GREEN_BOLD_BRIGHT + "*****Shipping address is validated****" + conhan.RESET);

		// String containing the value of text
		// System.out.println(billAdd[3]);

	}

	@Step("Verifying the OrderDate on the Order Confirmation Page")
	public static void OrderDateVerificationOnOrderConfPage() {
		RequestedDeliveryDateAndText.isDisplayed();
		String Deliverydate = RequestedDeliveryDate.getText();
		System.out.println(Deliverydate);

		int date1 = Integer.parseInt(dateFormat.format(date));
		// System.out.println(date1+1);
		int day = date.getDay();
		if (day != 0) {
			Assert.assertEquals(Deliverydate, toDateValidationNotSunday);
		} else {
			Assert.assertEquals(Deliverydate, toDateValidationOnSunday);
		}
	}

}
